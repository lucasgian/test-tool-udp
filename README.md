# test-tool-udp
Ferramenta de teste, em comunicação udp


# como funciona tudo!

## Primerio temos o gerador de mensagem o Generator.java, ele gera mesagens com tamanho definido
### Recebe como parametro pelo terminal o tamanho de uma string ex: java Generator [10000] ou varias string ex: java Generator [100] [80]

## Segundo temos o UDPClient que envia mensagem tanto de arquivo quanto pelo terminal
### Recebe como parametro pelo terminal 0 ou 1 (se deve ser um arquivo ou não), name host, caso seja passado pelo terminal uma infinidade de valores separados por espaço representado multiplas menssagens

## Terceiro temos o UDPServer que recebe uma mensagem (fica escultando na porta 6789)
### Não recebe parametro