FROM python:3.12.2

WORKDIR /app

COPY dist/ds-service-1.0.tar.gz .

RUN pip install --no-cache-dir ds-service-1.0.tar.gz

ENV FLASK_APP=src.app.main
ENV FLASK_RUN_HOST=0.0.0.0
ENV FLASK_RUN_PORT=8010
ENV PYTHONUNBUFFERED=1

EXPOSE 8010

CMD ["flask", "run"]