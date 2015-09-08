# fluid27
Challenge accepted!

#Quero colocar 20 mil imagens!

Vá no endereço https://fluid-challenge.herokuapp.com/posts/new e crie um novo post. Pra atualizar no app,puxa ele pra cima pra ele executar o swipe e atualizar e tchá-rá! Novas imagens aparecem para pessoas boas.

Sim, o post pede o endereço da imagem porque o heroku não salva imagens, eu precisaria colocar em outro endereço ou usar uma API tipo do photobucket pra isso. Como esse não era  foco...

#Quero atualizar os posts sem sair do app pq ele é muito legal mew!

Simples, vai até o começo da app e puxa pra cima. Ele vai executar a atualização e se tiver algo novo na API, vai baixar e novos posts maneirões estarão lá!

#Quero instalar o app diretamente!

hmmmm... você pode baixar aqui http://bit.ly/1FvM0Av (08/10/15 10:44) ou forkar o projeto, gerar um novo e ser feliz =D


#Bibliotecas externas

- Glide
Onde? https://github.com/bumptech/glide

Por quê? Precisava de uma biblioteca para fazer o cache das imagens. Em um momento, criei uma classe que era responsável por transformar um endereço de imagem em um Bitmap, uma imagem efetivamente. Funcionou, mas ao baixar para o próximo post logo o processo já era morto. Pesquisei como criar o cache e vi que daria um trabalho desnecessário, já que já haviam bibliotecas que faziam isso. Usei a lib Picasso e depois decidi pela Glide. Porque? Cache no próprio app e algo bem bacana na internet principalmente de gatinhos: Gif. A lib Glide é capaz de lidar com gifs (não funciona muito bem no emulador) e fazer cache no disco. Também mostra lida a transparência de um png.

Ponto fraco: Ela é um pouco maior que a Picasso mas o consumo de memória é mais baixo. Também tem que configurar para não perder a qualidade das imagens em alta defininição (arranquei essa config, queria a app voando de tão rápida).

- CircleImageView
Onde: https://github.com/hdodenhof/CircleImageView

Por quê? Eu queria a imagem circular, seguindo o layout proposto. Tentei fazer usando o layout por xml, criando uma nova forma circular e tentando aplicar nas imagens de avatar. Não rolou muito bem e googlando, descobri que teria q fazer a alteração por código, os exemplos eram bastante macarrônicos. Até que encontrei essa lib que faz exatamente o que preciso sem grande perdas.
Ponto fraco: O ScaleType sempre é centerCrop, então se precisar fazer de outro tipo vai dar ruim. Ela possui outras limitações que podem ser vistas no readme do github deles.

# O que usei da API do Android:

- Adapter, para criar um layout bacana. Porém fiz um esquema legal, o adapter tem o comportamento padrão de criar um novo elemento quando o scroll é feito e "matar" o adapter de cima que não é mais apresentado. Mas isso consome muito da VM android e quanto menos consumo, melhor. Eu verifico se tenho um adapter não sendo usado e se tiver, eu uso ele com as informações de um novo post. Então, é feito a reciclagem. 

Além de não aumentar o processamento, não agrido o meio ambiente (essa foi ruim, eu sei).

- Asynctask

Faço a requisição assincronamente para buscar o JSON contendo os posts na app. O código é meio feio (ele me incomoda), mas funciona e não inclui nenhuma biblioteca que faria o mesmo por mim. Transformo o JsonArray em posts, incluo em uma List de posts e tcha-rá! Trago pra view usando o Adapter.

- API

Escrevi usando rails (sem palavrões, por favor) e o como PaaS o heroku, pra executar a aplicação. A motivação foi "Preciso fazer algo rápido e q não dê trabalho" e assim foi feito!

#Licença

The MIT License (MIT)

Copyright (c) 2015 João Marcos Santana S. Jr.

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.
