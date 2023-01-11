
<?php
// Deletes the file called
if(isset($_GET["delFile"]) ){
    $path = "../upload/" . $_GET["delFile"];
    unlink($path);
}

?>
<html lang="en">
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>    
<script src="fileManagement.js"></script>
<script src="JS.js"></script>
<meta charset="UTF-8">
    <title> File Management </title>
    <link rel="stylesheet" href="style.css">
    
</head>

<body class = "files">
    <header>
    <h1> 
      <a classname= 'navbar-brand' href='index.php' >
          <img src="images/imgs/waves.png" class='d-line-block-align-text-top'> 
        </a>
        Water Front Property: File Management
      </h1>
    </header>
    <div class= "navigation">
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        
        <a href='index.php'>Home</a>
        |
        <a href='help.php'>Help</a>
        
      </nav>
    </div>
    
    <div class="box">
    <form action="fileManagement.php?up=1" method="post" enctype="multipart/form-data">
        <input type="file" name="fileToUpload" id="fileToUpload">
        <input type="submit" value="Upload" name="submit">
    </form>
  </div>
  <div class="box">
  <?php


if (isset($_POST["submit"])) {
    $target_dir = "../uploads/";
    $file = $_FILES["fileToUpload"];


    $imageFileType = 
        strtolower(pathinfo($file["name"],PATHINFO_EXTENSION));

    if($imageFileType != "txt"){
        echo "Only txt file types are supported.<br>";
        return;
    }

    $location = "../uploads/uploaded.txt";

    if(file_exists($location)){
        echo '<p>It already exists</p>';
    }

    if($file["size"] > 5000){
        echo "File to big";
        return;
    }

    switch ($_FILES['fileToUpload']['error']) {
        case UPLOAD_ERR_OK:
            $message = false;
            break;
        case UPLOAD_ERR_INI_SIZE:
        case UPLOAD_ERR_FORM_SIZE:
            $message .= ' - file too large.';
            break;
        case UPLOAD_ERR_PARTIAL:
            $message .= ' - file upload was not completed.';
            break;
        case UPLOAD_ERR_NO_FILE:
            $message .= ' - zero-length file uploaded.';
            break;
        default:
            $message .= ' - internal error #' . $_FILES['fileToUpload']['error'];
            break;
    }

    

    if (!$message) {
        if (!is_uploaded_file($file['tmp_name'])) {
            $message = 'Error uploading file - unknown error.';
        } else {
            
            if (!move_uploaded_file($file["tmp_name"], $location)) { // No error suppression so we can see the underlying error.
                $message = 'Error uploading file - could not save upload 
            (this will probably be a permissions problem in ' . $locaiton . ')';
            }
        }
    }
}?>
<?php
    $myFiles = scandir('../uploads/');
    foreach ($myFiles as $f) {
        if ($f[0] != '.') {
            echo '<p>' . $f . ' ';
            echo '<a href=' . '../uploads/' . $f . ' download><button type="button" class="btn">Download</button></a>';
            echo '<button id='. $f .' type="button" onclick="load(this)">Load</button>';
            
        }
    }
    

?>
  </div>
</body>
</html>
