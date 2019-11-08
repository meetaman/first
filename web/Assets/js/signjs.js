var log = document.querySelector("#log");
var reg = document.querySelector("#reg");
var register = document.querySelector(".register");
var signin = document.querySelector(".signin");
register.style.display = 'none';
reg.classList.remove('active');

log.addEventListener('click', function () {
    ss();
});


reg.addEventListener('click', function () {

    regis();

});

function ss() {
    register.style.display = 'none';
    signin.style.display = 'block';
    log.classList.add('active');
    reg.classList.remove('active');
}

function regis() {

    signin.style.display = 'none';
    register.style.display = 'block';
    reg.classList.add('active');
    log.classList.remove('active');
}


function validateReg() {
    var nam = document.getElementById("name").value;
    var emai = document.getElementById("email").value;
    var password = document.getElementById("pass").value;
    

    if (nam == "") {
        alert("Name must be filled out");
    }
   
    if (password != "") {
        if (password.length < 6) {
            alert("Password should be atleast 6 characters long");
        }
    } else {
        alert("Password must be filled");
    }
    if (emai != "") {
        var count = 0;
        for (var i = 0; i < emai.length; i++) {
            for (var j = 1; j < emai.length; j++)
                if (emai.charAt(i) == '@') {
                    if (emai.charAt(j) == '.')
                        count++;
                }
        }
        if (count == 0) {
            alert("Email format Invalid");
        }
    } else {
        alert("Email cannot be empty");
    }
}
    
    $(document).ready(function() {
                     $("#submit").click(function () {
                          $.ajax({
                               url : "servlet",
                              type: 'POST',
                              data : {
                                  name : $("#name").val(),
                                  email : $("#email").val(),
                                  phone : $("#phone").val(),
                                  userid: $("#user").val(),
                                  pass : $("#pass").val(),
                                 },
                             success : function(res){
                                 
                                     alert(res);
                                 console.log(res);
                             },
                              error: function(err){
                                  console.log(err);
                              }
                           });
                       });
                       
                       
             $("#login_btn").click(function () {
                          $.ajax({
                               url : "LoginServlet",
                              type: 'POST',
                              data : {
                                  username : $("#user1").val(),
                                  pwd : $("#pwd").val(),
                                    },
                             success : function(res){
                                 
                                     alert(res);
                                 console.log(res);
                                 var strr = res;
                                  if(strr.trim()==="Login Sucessful")
                                  {window.location.href="userprofile.html";}
                             
                         },
                              error: function(err){
                                  alert.log(err);
                                  console.log(err);
                              }
                           });
                       });       
                       
                       
            
                       
                       
        
                });
  
