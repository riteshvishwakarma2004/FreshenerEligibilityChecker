<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Renew</title>
<link rel="stylesheet" href="index.css">
</head>
<body>
	<div class="form">
		<h2>
			<code>Check Freshener Renewal</code>
		</h2>
		<br>
		
			
			<label for="serial_no">Serial No: </label> 
			<input type="text" name="serial_no" id="serial_no"><br><br>
			
			<button type="button" onclick="checkRenewal()">Check</button>
			
		
		<p id="option_prg" style="display: none;"></p><br>
		<p id="lastDatePrg" style="display: none;">Last Renewal Date:-</p><br>
		
		
			<button id="renew_btn" name="renew_btn" onclick="message()" style="display: none;"
				type="button">Renew</button>
		
        
        <div class="message_div" id="message" style="display:none;">
            <h1><code>Give Them, Their Freshener!</code></h1>
        </div>
        
       <button id="done" onclick="reload()" style="display:none;">Done</button>
        
        
	</div>
	
	<div class="add">
	<h2><code>Add New Vehicle</code></h2><br>
	<label for="New_serial_no"> New Serial No: </label> 
	<input type="text" name="New_serial_no" id="New_serial_no"><br><br>
	<button id="addNew" onclick="addNew()">Add</button><br> 
	<div  id="added" style="display:none;">
            <h1><code>Added Successfully</code></h1>
        </div>
	<br>
	</div>
										
	<script>
        function checkRenewal() {
            var serialNo = document.getElementById('serial_no').value;
            var xhttp = new XMLHttpRequest();
            xhttp.onload = function() {
                if (this.readyState == 4 && this.status == 200) {
                    // Execute the JavaScript code received from the servlet
                    eval(this.responseText);
                }
            };
            xhttp.open("POST", "check", true);
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send("serial_no=" + serialNo);
        }
        
        function addNew(){
        	var serialNo = document.getElementById('New_serial_no').value;
            var xhttp = new XMLHttpRequest();
            xhttp.onload = function() {
                if (this.readyState == 4 && this.status == 200) {
                    // Execute the JavaScript code received from the servlet
                    eval(this.responseText);
                }
            };
            xhttp.open("POST", "addNew", true);
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send("New_serial_no=" + serialNo);
        }
        
        function message(){
        	var Xhttp = new XMLHttpRequest();
        	Xhttp.onload = function(){
        		if(this.readyState == 4 && this.status == 200){
        			eval(this.responseText);
        		}
        	}
        	Xhttp.open("get" ,"renew", true);
        	
        	Xhttp.send();
        }
        
        function reload(){
        	window.location.reload();
        }
        
        
        
        
    </script>

</body>
</html>