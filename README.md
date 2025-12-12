# 🚀 Minha Jornada na Programação Orientada a Objetos (POO) com Java

Este repositório contém minhas anotações e exercícios sobre os fundamentos de Java e os pilares que sustentam o desenvolvimento de softwares robustos e organizados.

---

## 🛡️ Encapsulamento e Boas Práticas
Aprendi que a segurança do código começa com a forma como protegemos nossos dados. Em vez de deixar os **atributos** de uma classe expostos, utilizamos o **Encapsulamento**.

* **Atributos Privados (`private`):** Garante que os dados de uma classe não sejam acessados ou alterados diretamente por outras classes.
* **Métodos Getters e Setters:** São as "portas de entrada e saída" controladas. 
    * `get`: Entrega o valor da variável.
    * `set`: Define ou manipula o valor, permitindo validar os dados antes de salvá-los.

## 🏗️ Construtores
Entendi que a responsabilidade de "nascer" com as informações corretas pertence à própria classe e não ao método `main`. Com o **Método Construtor**, definimos quais atributos são obrigatórios no momento em que o objeto é instanciado, garantindo que o objeto nunca comece em um estado inválido.

---

## 🏛️ Os 3 Pilares da POO + Abstração
Para criar sistemas escaláveis, Java se baseia em quatro conceitos fundamentais:

### 1. Abstração
É o processo de esconder os detalhes complexos e mostrar apenas o essencial. No Java, fazemos isso através de **Interfaces** e **Classes Abstratas**, definindo "o que" o objeto faz, sem necessariamente dizer "como" ele faz.

### 2. Encapsulamento
É a arte de proteger os dados e esconder a implementação interna da classe, expondo apenas o que é estritamente necessário através de métodos públicos.

### 3. Herança
Permite que uma classe (filha) herde atributos e comportamentos de outra classe (pai). Isso evita a repetição de código e nos permite criar hierarquias lógicas entre os objetos.

### 4. Polimorfismo
A capacidade de um objeto ser referenciado de várias formas. Graças ao polimorfismo, podemos ter um método com o mesmo nome que se comporta de maneira diferente dependendo do objeto que o executa (por exemplo, um método `emitirSom()` que funciona de formas distintas para um `Cachorro` ou um `Gato`).

---

