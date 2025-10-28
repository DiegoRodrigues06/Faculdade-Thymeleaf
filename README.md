## Sistema de Cadastro (Faculdade)

Um sistema web simples desenvolvido como projeto escolar com **Spring Boot + Thymeleaf + JPA (MariaDB)**
para gerenciar **Alunos, Professores, Cursos e Disciplinas**.

---

### Tecnologias utilizadas

| Categoria      | Tecnologias                                           |
| -------------- | ----------------------------------------------------- |
| Back-end       | Spring Boot, Data JPA, Validation, MariaDB Driver     |
| Front-end      | Thymeleaf,  Bootstrap 5                               |
| Banco de Dados | MariaDB                                               |
| Build Tool     | Maven                                                 |
| Linguagem      | Java 17                                               |

---

### Estrutura de pacotes

```
src/main/java/com/faculdade/faculdade/
│
├── controller/        → Controladores MVC (AlunoController, CursoController, etc)
├── dto/               → Objetos de transferência de dados (DTOs)
├── mapper/            → Conversores entre Model e DTO
├── model/             → Entidades JPA (Aluno, Endereco, Curso, Professor, Disciplina)
├── repository/        → Interfaces JPA (extensões de JpaRepository)
├── service/           → Lógica de negócio e integração com o repositório
└── Application.java   → Classe principal (Spring Boot)
```

E as páginas HTML ficam em:

```
src/main/resources/templates/
│
├── alunos/
│   ├── lista.html
│   └── form.html
├── cursos/
│   ├── lista.html
│   └── form.html
├── disciplinas/
│   ├── lista.html
│   └── form.html
├── professores/
│   ├── lista.html
│   └── form.html
└── index.html
```

---

### Configuração do banco de dados

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/faculdadeuni
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect
```
---

### Estrutura do CRUD

Cada entidade tem:

* `Model` → Mapeada com JPA
* `DTO` → Usada para transferência de dados entre camadas
* `Mapper` → Converte entre DTO e Model
* `Repository` → Interface que herda de `JpaRepository`
* `Service` → Contém a lógica de negócio
* `Controller` → Faz a ligação entre view e service
* `Templates (HTML)` → Interface visual via Thymeleaf

---

### Exemplo de URL para teste

| Entidade    | Listagem       | Novo                | Excluir                     |
| ----------- | -------------- | ------------------- | --------------------------- |
| Alunos      | `/alunos`      | `/alunos/novo`      | `/alunos/excluir/{id}`      |
| Professores | `/professores` | `/professores/novo` | `/professores/excluir/{id}` |
| Cursos      | `/cursos`      | `/cursos/novo`      | `/cursos/excluir/{id}`      |
| Disciplinas | `/disciplinas` | `/disciplinas/novo` | `/disciplinas/excluir/{id}` |


