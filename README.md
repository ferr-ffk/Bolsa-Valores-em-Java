# 💰 Bolsa de Valores
_Prof° Ugo Henrique Pereira da Silva_

<div style="display: flex; justify-content: center; align-items: center;">

![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)

</div>

Este projeto simula a bolsa de valores, com todos os aspectos de compra e venda de ordens, além das funcionalidades de armazenar as trocas em arquivos de texto no próprio projeto.

## 🧍 Autores

| Integrante               | Funcionalidade          |
|:------------------------:|:-----------------------:|
| Fernando Freitas de Lira | Classes de modelo       |
| Davi Gomes de Sousa      | Classes de utilidade    |
| Francine Midori          | Gestão geral do projeto |

## 📖 Ferramentas e Bibliotecas utilizadas

* Java FileReader library
* Eclipse IDE
* IntellijIdea

## 🚀 Datasets

1. Os dados de empresas e informações adicionais foram retirados do [site oficial da B3](https://www.b3.com.br/pt_br/market-data-e-indices/servicos-de-dados/market-data/consultas/boletim-diario/dados-publicos-de-produtos-listados-e-de-balcao/).

1. A estrutura de um ativo pode ser encontrada no [site da bolsa de valores de São Paulo](https://www.b3.com.br/pt_br/produtos-e-servicos/negociacao/renda-variavel/acoes.htm).

1. As empresas [listadas na B3](https://www.b3.com.br/pt_br/produtos-e-servicos/negociacao/renda-variavel/empresas-listadas.htm).

## 🧰 Funcionalidades

O sistema possui modos de compra e ordem de uma ação por um investidor de uma empresa tal cadastrada no sistema de arquivos. Cada investidor tem um saldo disponível ao ser instanciada e será impossibilitado de compra caso não possuir saldo suficiente.

A empresa possui nome popular e código na bolsa de valores, retirados do site oficial da B3. Ao ser instanciada, é entrado o valor de cada cota e o número total delas. Não será possível comprar uma cota se o valor de cotas for zero.

O sistema possui uma biblioteca personalizada de estruturas de dados como Fila, Pilha e Árvore, todas com estratégia encadeada de armazenamento. A classe fila é utilizada para armazenamento de cada papel comprado por um investidor, em sua carteira pessoal; como a pilha é usada para registrar as empresas no ramo de negócios.

## 💻 Instalação e uso

O sistema possui estrutura de arquivos simples para fácil uso. Apenas baixe o arquivo ```.jar``` na aba _Releases_ no github e referencie ele em seu projeto Java. [Como faço isso?](https://www.alura.com.br/apostila-java-orientacao-objetos/ferramentas-jar-e-javadoc#:~:text=O%20próprio%20Eclipse%20já%20nos,importado%20e%20clicar%20em%20Open.)

### 📁 Uso de armazenamento de arquivos

Por padrão, o sistema irá armazenar os históricos de ordens e empresas cadastradas na raíz do projeto. É possível mudar para um caminho relativo da sua máquina:

```Java
Corretora.setCaminhoArquivo("C:\\Program Files\\Notas\\Fernando\\Corretoras.txt");
```

E o equivalente para a classe Empresa:
    	
```Java    	
Empresa.setCaminhoArquivo("C:\\Program Files\\Notas\\Fernando\\Empresas.txt");
```

Lembrando que para cada subpasta deve utilizar ```\\```.

É possível também mudar os caminhos na classe ```LocaisArquivoTexto.java``` para mudança no projeto todo, apenas mude o valor das constantes lá:

```Java
public static final String HISTORICO_ORDENS_TXT_PADRAO = "C:\\Program Files\\Notas\\Davi\\Empresas.txt";
	
public static final String EMPRESAS_TXT_PADRAO = "C:\\Program Files\\Notas\\Davi\\Empresas.txt";
```

## 🏃‍♀️ O que será feito no projeto?

- [X] Implementação das entidades de modelo
- [X] Implementação das classes de utilidades como Fila, Pilha e Árvore
- [X] Armazenamento das ordens de compra e venda em arquivos ```.txt```
- [ ] Geração de relatórios
- [ ] Simulação de flutuação de valores de ações
