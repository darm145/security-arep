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
            axios.post("login", user).then(function (response) {
                console.log(response.data.accessToken);
                localStorage.setItem("token", response.data.accessToken);
                window.location.replace("/form.html");
            }).catch(function (error) {
                console.log(error);
                alert("datos incorrectos");
            });
            console.log(name);
            console.log(pass);
        },
        checkLogged: function () {
            if (localStorage.getItem("token") == undefined || localStorage.getItem("token") == null) {
                window.location.replace("/index.html");
            }
        },
        logout: function () {
            localStorage.removeItem("token");
            window.location.replace("/index.html");
        },
        getHello: function () {
            var name=document.getElementById("inputname").value;
            axios.get("/hello/" + name)
                .then(function (response) {
                    document.getElementById("editable").innerHTML = response;
                console.log(document.getElementById("editable").innerHTML);
                    console.log(response);
                })
                .catch(function (error) {
                    // handle error
                    console.log(error);
                })
            
        }

    }

})();