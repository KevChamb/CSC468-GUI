<?php

?>
<html lang="en">
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="Table.js"></script>
<script src="JS.js"></script>
<meta charset="UTF-8">
    <title> Water Front Property </title>
    <link rel="stylesheet" href="style.css">
   
</head>

<!--page start-->
<header>
    
    <h1> 
      <a classname= 'navbar-brand' href='#' >
          <img src="images/imgs/waves.png" class='d-line-block-align-text-top'> 
        </a>
        Water Front Property
    </h1>
  </header>
<body class="index">
   <!--page content -->
  
  <div class= "navigation">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      
      <a href='fileManagement.php'>File Management </a>
      |
      <a href='help.php'> Help</a>
      
    </nav>
  </div>
  <br>
  <h2> Formats </h2>
  <div class="buttons">
    <button id="addRow" type="button" class="btn btn-light">Add Row</button>
    <button id="save" type="button" class="btn btn-light">Save</button>
    <button id="reset" type="button" class="btn btn-light">Reset</button>
    <button id="hotels" type="button" class="btn btn-light">All Hotels</button>
    <button id="mixed" type="button" class="btn btn-light">Mixed</button>
    <button id="undo" type="button" class="btn btn-light">Undo</button>
    <button id="redo" type="button" class="btn btn-light">Redo</button>
  </div>
  <div class="around">
    <hr>
   
    <div class = "waterfront" id="waterfront">
    </div>
  </div>

</body>
</html>