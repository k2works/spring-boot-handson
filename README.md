# SpringBootHand-on

## 概要

### 目的

### 前提

| ソフトウェア   | バージョン | 備考 |
| :------------- | :--------- | :--- |
| java           | 8          |      |
| node           | 8.10.0     |      |
| docker         | 1.23.2     |      |
| docker-compose | 1.23.2     |      |
| sam cli        | 0.12.0     |      |

## 構成

- [構築](#構築)
- [配置](#配置)
- [運用](#運用)

## 詳細

### 構築

```bash
$ mvn archetype:generate -DgroupId=k2works -DartifactId=spring-boot-handson -Dversion=1.0-SNAPSHOT \
       -DarchetypeGroupId=com.amazonaws.serverless.archetypes \
       -DarchetypeArtifactId=aws-serverless-springboot2-archetype \
       -DarchetypeVersion=1.3.1
$ mvn clean package
$ sam local start-api --template sam.yaml
```

http://localhost:3000/ping
```bash
$ curl -s http://127.0.0.1:3000/ping | python -m json.tool
```

```bash
$ aws s3 mb s3://spring-handson-k2works
$ aws cloudformation package --template-file sam.yaml --output-template-file output-sam.yaml --s3-bucket spring-handson-k2works
$ aws cloudformation deploy --template-file output-sam.yaml --stack-name ServerlessSpringApi --capabilities CAPABILITY_IAM
$ aws cloudformation describe-stacks --stack-name ServerlessSpringApi
```

**[⬆ back to top](#構成)**

### 配置

```bash
$ sam package --template-file sam.yaml --s3-bucket spring-handson-k2works --output-template-file packaged.yaml
$ sam deploy --template-file packaged.yaml --stack-name ServerlessSpringApi --capabilities CAPABILITY_IAM --parameter-overrides ENV=production
```

**[⬆ back to top](#構成)**

### 運用

```bash
$ npm init
$ npm install npm-run-all watch foreman rimraf cpx --save-dev
$ touch Procfile
$ npm install --save-dev browser-sync
$ npx  browser-sync init
```

```bash
$ aws cloudformation delete-stack --stack-name ServerlessSpringApi
```

**[⬆ back to top](#構成)**

### 開発

**[⬆ back to top](#構成)**

## 参照

- [SpringBootでマイクロサービスを作ってKubernetesにデプロイしてみる【実践編】](https://github.com/nebosuke/aks_study)
