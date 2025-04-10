# API de Profissionais de Saúde

API para gerenciamento de disponibilidade de profissionais de saúde.

## Requisitos

- Java 17 ou superior
- Maven 3.6 ou superior

## Como executar

### Usando o Maven

```bash
# Compilar o projeto
mvn clean package

# Executar a aplicação
java -jar target/api-profissionais-saude-1.0.0.jar
```

### Usando os scripts

#### Windows
Execute o arquivo `run.bat`

#### Linux/Mac
1. Dê permissão de execução ao script:
```bash
chmod +x run.sh
```

2. Execute o script:
```bash
./run.sh
```

## Documentação da API

Após iniciar a aplicação, a documentação da API estará disponível em:

- Interface Swagger UI: http://localhost:8080/swagger-ui.html
- Documentação OpenAPI (JSON): http://localhost:8080/api-docs

## Endpoints disponíveis

- `GET /api/profissionais` - Lista todos os profissionais
- `GET /api/profissionais/especialidade/{especialidade}` - Busca profissionais por especialidade
- `GET /api/profissionais/busca?nome={nome}` - Busca profissionais por nome
- `GET /api/profissionais/especialidades` - Lista todas as especialidades disponíveis
