<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Demo JSP</title>
    </head>
<body>
    <h1>Send an omikuji!</h1>
    
     <form action="/login" method="post">
          
           
          <p>Pick any number from 5 to 25<div><input type="number" name="number"></div></p>
             
          <p>Enter the name of an city.<div><input type="text" name="city"></div></p>
            
          <p>Enter the name of any real person<div><input type="text" name="person"></div></p>
            
          <p>Enter professional endeavor or hobby:<div><input type="text" name="hobby"></div></p>
            <p>Enter any type of living thing.<div><input type="text" name="living"></div></p>
              <p>Say something nice to someone:<div><textarea name="textarea"></textarea></div></p>
           <p>Send and show a friend<div><button>Send</button></div></p>
        </form>
</body>
</html>

</body>
</html>