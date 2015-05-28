##### Environment:
* OS is RedHat 6.3. or  any other modern Linux
* REST API:   
    * PUT - starts/stops services on runtime nodes
    * GET - checks what processes are running on runtime nodes

##### Description:
Working environment consists of `master` node and 32 `runtime nodes`.    
On master and runtime nodes some kind of `REST API` server and client are installed.

##### Task:
    Create a test for testing REST API. (You could use a tool like Jmeter or any other third party tool or create/program your own script (python, bash, java, ruby, etc))
    Test plan (for all 32 nodes):
        1. Send a call to stop all services on runtime node
        2. Wait while all services are stopped
        3. When all services on runtime node are stopped copy some files from master node to runtime node.
        4. Check if file is present on runtime nodes.
        5. Add negative test cases.


##### Example:

1 **PUT**     

    - request
        - url - http://hostip:port/cdm-rest-api/configure/v1/server/runtimehostname/app/instance1/action
        - data - {"action":"stop"}
        
    - response
        {"action":"stop",
        "status":200,
        "response":{
        "message":"Stopping resources has triggered successfully"}}

2 **GET**             

    - request    
        - url - http://masterhostip:port/cdm-rest-api/configure/v1/server/runtimehostname/app/instance1          
    - response         
        {"appStatus":"started",         
        "resourceStats":{         
        "total":4,        
        "upActive":4,       
        "upInactive":0}}     
        