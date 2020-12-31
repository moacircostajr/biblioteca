[![Build Status](https://travis-ci.org/moacircostajr/biblioteca.svg?branch=master)](https://travis-ci.org/moacircostajr/biblioteca)
# biblioteca
Software criado com o propósito de auxiliar o gerenciamento de bibliotecas.

Desenvolvido com as tecnologias MySQL, Java 8, CDI, JSF e iReport. 

### Introdução

Estas instruções lhe permitirão obter uma cópia do projeto e executá-lo na sua máquina local para desenvolvimento e testes. Veja as notas de compilação para saber como compilar o projeto.

## Pré-requisitos

A tecnologia de desenvolvimento dessa api pode ser instalada através do comando `sudo apt install openjdk-8-jdk maven` (no GNU/LINUX distribuição Debian/Ubuntu/derivados).

## Instalação

Após o download deste projeto, dentro de sua pasta principal deve ser executado o comando `mvn install`, para que seja feito o download e a instalação das dependências do projeto.

Após a instalação das dependências, basta executar os passos informados nas notas a seguir.

## Ambiente de desenvolvimento

O uso de uma IDE com suporte a linguagem java é essencial para se obter fluidez no desenvolvimento desse projeto. As IDEs mais conhecidas são o Eclipse, IntelliJ, Netbeans e Visual Studio Code.

A aplicação deve ser executada em um servidor Apache Tomcat, o qual deve ser configurado na IDE para desenvolvimento local.

## Compilação

Execute na pasta raiz do projeto o comando `mvn clean compile package` para compilar e empacotar o projeto.

O projeto compilado poderá ser encontrado no diretório `target/`, e deverá ser copiado para a pasta `webapps` do Apache Tomcat.

## Ajuda

Para obter mais informações sobre as tecnologias utilizadas no desenvolvimento desta API, acesse [JAVA Docs](https://docs.oracle.com/javase/8/), [JSF Docs](http://www.javaserverfaces.org/documentation) e/ou [iReport](http://mz.pro.br/LPII/LPII_170313_IReport_I.pdf).

## Licença

Este projeto está licenciado sob os termos da [GNU General Public License v3.0](http://licencas.softwarelivre.org/gpl-3.0.pt-br.html).

## Autor

* **Moacir Costa** - *Desenvolvedor inicial*

## Agradecimentos

* A Jesus Cristo, que me deu fé, coragem, inteligência e determinação para chegar até aqui
* Ao meu irmão, Claudio Costa, que me ensinou a programar aplicações web nos seus momentos de folga


