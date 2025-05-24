# 🎂 AppDesktopConfeitaria

Este é um sistema de gerenciamento de pedidos para uma confeitaria, desenvolvido como uma aplicação desktop em **Java**. O projeto utiliza **Swing** para a interface gráfica e **PostgreSQL** como banco de dados.

## ✨ Funcionalidades Principais

- 🧾 **Gerenciamento de Pedidos**: Criação, edição, exclusão e busca de pedidos.
- 👤 **Gerenciamento de Clientes**: Cadastro, atualização e exclusão de clientes.
- 🍫 **Gerenciamento de Produtos**: Controle de produtos disponíveis, incluindo tipos de chocolate.
- 🔐 **Gerenciamento de Usuários**: Controle de acesso por meio de login e senha.
- 🔎 **Busca Avançada**: Pesquisa parcial com filtros para clientes, produtos, pedidos e itens de pedido.
- 🖥️ **Interface Gráfica**: Desenvolvida com Swing, com componentes como tabelas, campos de texto e botões.

## 🛠️ Tecnologias Utilizadas

- ☕ **Java**: Linguagem principal do projeto.
- 🖼️ **Swing**: Biblioteca para construção da interface gráfica.
- 🐘 **PostgreSQL**: Banco de dados relacional para armazenamento das informações.
- 🔁 **RxJava**: Para manipulação reativa de dados.
- 📅 **JCalendar**: Componente para seleção de datas na interface gráfica.

## 🧱 Camadas do Projeto

1. 📦 **Models**: Contém as classes que representam as entidades do sistema, como `Pedido`, `Cliente`, `Produto`, e seus respectivos DAOs e serviços.
2. 🪟 **Views**: Interface gráfica do sistema, com classes como `PedidoView`, `ClienteView` e `ProdutoView`.
3. 🧭 **Controllers**: Controladores que conectam as views aos serviços e DAOs.
