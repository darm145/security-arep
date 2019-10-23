app = (function () {
    return {
        getUsers: function () {
            console.log("asd");
            $.get("/User", function (data) {
                console.log(data);

            });
        },
        login: function () {
            var nom = document.getElementById("name").value;
            var pass = document.getElementById("password").value;
            var user = { name: nom, password: pass };
            axios.post("login",user).then(function(response){
                console.log(response.data.accessToken);
                localStorage.setItem("token",response.data.accessToken);
            }).catch(function (error) {
                console.log(error);
              });
            console.log(name);
            console.log(pass);
        }

    }

})();