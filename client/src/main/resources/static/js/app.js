app=(function(){
    return{
        getUsers:function(callback){
            console.log("asd");
            $.get("/User",function(data){
                console.log(data);
                
			});
        },
        test:function(){
            console.log("asd");
        }

    }
    
})();