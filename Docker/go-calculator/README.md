* You need to have docker installed to work

* Allow the sh script be executable with: chmod +x dockercommands.sh

* Now you can run the calculator
	- Build docker image:
	> . dockercommand.sh && build_microservice

	- To start the calculator execute: 
	> . dockercommands.sh && start_microservice

	- To stop
	> . dockercommands.sh && stop_microservice

	- To check status (if is running or not)
	> . dockercommands.sh && status_microservice gocalculator

* The web application will be on http://localhost:8080/calc/[operation]/[num1]/[num2]

* For example:
    - http://localhost:8080/calc/div/10/5
    - http://localhost:8080/calc/sum/5/8

* Valid operations are sum, sub, mul and div

* You can also access the history of operations done successfully on
    - http://localhost:8080/calc/history
