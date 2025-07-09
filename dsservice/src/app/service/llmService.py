from typing import Optional
import os
from langchain_core.prompts import ChatPromptTemplate
from pydantic import BaseModel, Field
from langchain_mistralai import ChatMistralAI
from app.service.Expense import Expense
from langchain_core.utils.function_calling import convert_to_openai_tool
from dotenv import load_dotenv

class LLMService:
    def __init__(self):
        load_dotenv()

        self.prompt = ChatPromptTemplate.from_messages([
            (
                "system",
                "You are an expert extraction algorithm. "
                "Only extract relevant information from the text. "
                "If you do not know the value of an attribute asked to extract, "
                "return null for the attribute's value.",
            ),
            ("human", "{text}")
        ])

        self.apiKey = os.getenv('MISTRAL_API_KEY')
        self.llm = ChatMistralAI(
            api_key=self.apiKey,
            model="open-mistral-7b",
            temperature=0
        )

        self.runnable = self.prompt | self.llm.with_structured_output(schema=Expense)

    def runLLM(self, message):
        try:
            return self.runnable.invoke({"text": message})
        except Exception as e:
            return {"error": str(e)}