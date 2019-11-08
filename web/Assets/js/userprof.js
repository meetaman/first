//
// function redirect(){
//        window.location = "GetInfo";
////        }
//function editFunc()
//{
//    document.getElementById("myModal").style.display="block";
//}
//    
//function updateDetail()
//{
//    $( "edit_Sec" ).load(window.location.href + "edit_Sec" );
//    document.getElementById("myModal").style.display="none";
//}

function createPost()
{
     
    var val =($("#posts").val()).trim();
//    if(val!=="")
//    {
                          $.ajax({
                               url : "Post",
                              type: 'POST',
                              data : {
                                  str : val
                                      },
                             success : function(res){
                                   
//                                 console.log(array[1]);

                                 
                         },
                              error: function(err){
                                  alert.log(err);
                                  console.log(err);
                              }
                           });
                          
//    }
//    else
//        alert("Post cannot be empty!");
  
  }
        
        function splitting(res)
        {
            console.log("called");
            var temp = res;
            var array=temp.split("#");
            var postss = array[0].split("`");
            var dates  = array[1].split("t");
            console.log(postss);
            console.log(dates);
            for(var i=0;i<postss.length;i++)
            {

                $("#tb").append('<div class="panel panel-default img-rounded"><div class="panel-heading" >Posted At: '+dates[i]+'</div><div class="panel-body">'+postss[i] +'</div><div class="panel-footer"><button i="ed_post" data-target="#postModal" data-toggle="modal">Edit</button> <button id="del_post">Delete</button></div></div>');
            }
        }

    $(document).ready(function() {
    
        
        
         $.ajax({
           url: 'GetInfo',
             type: 'GET',
           error: function(err) {
               alert(err);
               console.log(err);
             
           },
           data:{
               
           },
           success: function(res) {
                alert(res);
                  
                var aa=[];
                aa= res.split("/");
                console.log(typeof res);
                console.log(res);
                document.getElementById("dispAge").innerHTML=  "<span style='color: #389dd7;'>"+ aa[1].trim()+"</span>";
                document.getElementById("dispCity").innerHTML="<span style='color: #389dd7;'>"+ aa[2].trim()+"</span>";
                document.getElementById("dispColl").innerHTML="<span style='color: #389dd7;'>"+ aa[3].trim()+"</span>";
                document.getElementById("dispEma").innerHTML="<span style='color: #389dd7;'>"+ aa[4].trim()+"</span>";
                document.getElementById("dispPhone").innerHTML="<span style='color: #389dd7;'>"+ aa[5].trim()+"</span>";
                for(var i=0;i<aa.length;i++)
                {
                console.log(aa[i].length);    
                }
            }        
        });
        
        
        
        
        
        
        
         $.ajax({
           url: 'GetPost',
             type: 'GET',
           error: function(err) {
               alert(err);
               console.log(err);
             
           },
           data:{
               
           },
           success: function(res) {
                alert(res);
//                var aa=[];
//                aa= res.split("/");
//                console.log(typeof res);
                  splitting(res);
                console.log(res);
//                $("#addHere").prepend(val);
//                document.getElementById("dispAge").innerHTML=  "<span style='color: #389dd7;'>"+ aa[1].trim()+"</span>";
//                document.getElementById("dispCity").innerHTML="<span style='color: #389dd7;'>"+ aa[2].trim()+"</span>";
//                document.getElementById("dispColl").innerHTML="<span style='color: #389dd7;'>"+ aa[3].trim()+"</span>";
//                document.getElementById("dispEma").innerHTML="<span style='color: #389dd7;'>"+ aa[4].trim()+"</span>";
//                document.getElementById("dispPhone").innerHTML="<span style='color: #389dd7;'>"+ aa[5].trim()+"</span>";
//                for(var i=0;i<aa.length;i++)
//                {
//                console.log(aa[i].length);    
//                }
            }        
        });
        
        
        
        
        
        
        
//        $("#post_button").click(function (){
//            
//                checkblank = true;
//        var str = document.getElementById('#posts').value;
//        if(str===null || str==="")
//        {
//            checkblank=false;
//            console.log("hello");
//        }
//        else
//        {
//
//        }
//        alert(checkblank);            
//        });
//        
        $("#save_btn").click(function () {
                          $.ajax({
                               url : "UserDetails",
                              type: 'POST',
                              data : {
                                  age : $("#dob").val(),
                                  city : $("#city").val(),
                                  college: $("#college").val(),
                                    },
                             success : function(res){
                                 
                                     alert(res);
                                 console.log(res);
                             },
                              error: function(err){
                                  alert.log(err);
                                  console.log(err);
                              }
                           });
                       });    
                       
                       
                       
         $("#del_post").click(function () {
            
             
         });
 });
