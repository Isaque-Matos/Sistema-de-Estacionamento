# Sistema de Estacionamento
 Projeto desenvolvido no Colégio Engenheiro Salvador Arena para a disciplina de  Algoritmos e Linguagens de Programação

O projeto **Estacionamento Garagem Boys** é uma aplicação Java que simula o controle de um estacionamento, onde é possível cadastrar veículos, retirar veículos e gerar tickets de saída. A aplicação permite a gestão de até 30 vagas, realizando verificações de ocupação e mantendo o controle de veículos estacionados.

## Funcionalidades
O sistema oferece três funcionalidades principais:

1. **Cadastrar Veículo e Vaga**  
   Permite o cadastro de um veículo no estacionamento, associando-o a uma vaga específica. O sistema verifica se a vaga já está ocupada antes de realizar o cadastro.

2. **Retirar Veículo (Gerar Ticket)**  
   Permite retirar um veículo do estacionamento e gerar um ticket com as informações de estacionamento, como horário de entrada, saída e valor total a ser pago.

3. **Listar Veículos no Estacionamento**  
   Exibe todos os veículos atualmente estacionados no estacionamento, com informações como número da vaga, modelo, cor, e horário de entrada.

## Horário de Entrada e Saída
O sistema utiliza a biblioteca **`java.time`** para capturar o **horário de entrada** e o **horário de saída** dos veículos em tempo real. Ao cadastrar um veículo no estacionamento, a data e o horário de entrada são registrados automaticamente no momento do cadastro.

## Geração do Ticket
Após utilizar a opção de retirada de veículo, o sistema solicita a **placa do veículo** e gera um **arquivo .txt** com as informações do veículo, como número da vaga, bloco, piso, modelo, e horário de entrada e saída. Além disso, o sistema calcula o tempo total de estacionamento e o valor a ser pago pelo cliente.

## Desconto
O sistema oferece um **desconto especial** para veículos cujas **placas** contêm as letras **L**, **U**, **I**, **S** (independente da ordem). Quando o sistema detecta essas letras na placa do veículo, ele aplica um **desconto fixo** no valor total a ser pago.

Por exemplo, para uma placa como **LUI1S23** ou **ILU2S33**, o sistema identificará as letras **L**, **U**, **I**, e **S**, e aplicará o desconto.
