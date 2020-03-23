- Para rodar a aplicação, baixe o docker em sua máquina

- Excute o comando ./gradlew build na pasta da aplicação

- Após, execute o comando: sudo docker build -t calculadora .
	- Use somente o sudo se o usuário da máquina ainda não está configurado no docker:
		Use sudo usermod -aG docker ${USER}. 

- Realizado o build da imagem do docker, execute: sudo docker run -p 8080:8080 calculadora
	- -p 8080:8080 é para setar em qual porta irá rodar a aplicação.

- No browser acesse a url: localhost:8080/Tema3Cloud-1.0/calculator?firstNumber=[inserir o numero desejado]&op=[escrever a operação desejada]&secondNumber=[inserir numero desejado]

- Assim que executar irá aparecer o resultado da operação

- Para ver o log das operações feitas, acesse: localhost:8080/Tema3Cloud-1.0/calculator?log

- Operações disponíveis:
	- sum
	- sub
	- mult
	- div
	- pow
