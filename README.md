# interface
# Sistema de Locadora de Veículos

Projeto desenvolvido em Java para processamento de aluguel de veículos com cálculo automático de faturamento e impostos.

O sistema calcula:
- pagamento básico
- imposto
- valor total da fatura

As regras de negócio consideram:
- cobrança por hora para locações de até 12 horas
- cobrança por diária para locações acima de 12 horas
- imposto brasileiro progressivo

---

## Tecnologias utilizadas

- Java 21
- Programação Orientada a Objetos
- Interfaces
- Polimorfismo
- API Date/Time (`LocalDateTime`)
- Maven (opcional)

---

## Conceitos aplicados

- Interface
- Injeção de dependência
- Inversão de dependência
- Composição
- Camadas de serviço
- Separação de responsabilidades

---

## Estrutura do projeto

```text
src
├── application
│   └── Program.java
│
├── entities
│   ├── Vehicle.java
│   ├── CarRental.java
│   └── Invoice.java
│
└── services
    ├── TaxService.java
    ├── BrazilTaxService.java
    └── RentalService.java
```

---

## Regra de negócio

### Locação até 12 horas

Cobrança por hora:

```text
valor = horas * preçoPorHora
```

---

### Locação acima de 12 horas

Cobrança por diária:

```text
valor = dias * preçoPorDia
```

---

### Imposto

- 20% para valores até 100.00
- 15% para valores acima de 100.00

---

## Exemplo de execução

```text
Entre com os dados do aluguel

Modelo do carro: Civic

Retirada (dd/MM/yyyy HH:mm):
25/06/2018 10:30

Retorno (dd/MM/yyyy HH:mm):
25/06/2018 14:40

Entre com o preço por hora:
10.00

Entre com o preço por dia:
130.00
```

### Saída

```text
FATURA:

Pagamento básico: 50.00
Imposto: 10.00
Pagamento total: 60.00
```

---

## Exemplo de arquitetura

```text
Program
   ↓
RentalService
   ↓
TaxService (interface)
   ↓
BrazilTaxService
```

O sistema foi desenvolvido utilizando interfaces para desacoplar as regras de imposto da lógica principal de locação.

---

## Como executar

### Clonar o projeto

```bash
git clone https://github.com/seu-usuario/nome-repositorio.git
```

---

### Entrar na pasta

```bash
cd nome-repositorio
```

---

### Compilar

```bash
javac application/Program.java
```

---

### Executar

```bash
java application.Program
```

---

## Possíveis melhorias

- suporte para múltiplos países
- interface gráfica
- persistência em banco de dados
- testes automatizados
- API REST com Spring Boot

---

## Autor

Bruno Damascena

---

## Licença

Projeto para fins educacionais.
