app=(function(){
    return{
        getUsers:function(){
            console.log("asd");
            $.get("/User",function(data){
                console.log(data);
                
			});
        },
        login:function(){
            
        }

    }
    
})();