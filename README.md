# 🔗 Webhook Callback Service

Este projeto é uma aplicação desenvolvida em **Java 21** com **Spring Boot 3.5**, que tem como objetivo receber notificações via HTTP (webhooks) e realizar um callback para uma URL previamente configurada.

## 🚀 Descrição

O serviço expõe um endpoint HTTP capaz de receber eventos (ex.: transações ou qualquer outro tipo de notificação) no formato JSON. Assim que uma notificação é recebida e processada com sucesso, o sistema realiza um **callback automático** para uma **URL fixa**, informando outro sistema sobre o recebimento desse evento.

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5**
- **Spring Web**
- **SLF4J** (para logs)
- **Maven** (gerenciamento de dependências)

---

## 🔗 Funcionalidades

- ✅ Recebimento de notificações via HTTP POST (webhook)
- ✅ Validação dos dados recebidos
- ✅ Callback automático para uma URL fixa após processamento bem-sucedido
- ✅ Logs de requisições e callbacks para rastreabilidade
- 🚀 Fácil configuração da URL de destino do callback via `application.yml` ou variáveis de ambiente

---

## 📜 Exemplo de Payload Recebido

```json
{
  "id": "123456789",
  "status": "COMPLETED",
  "valor": "150.75",
  "data": "2025-06-18T15:30:00Z"
}
