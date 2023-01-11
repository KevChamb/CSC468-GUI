<html lang="en">
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>    
<script src="JS.js"></script>
<meta charset="UTF-8">
    <title> Help </title>
    <link rel="stylesheet" href="style.css">
    
</head>

<body class= "help">
  <header>
  <h1> 
    <a classname= 'navbar-brand' href='index.php' >
        <img src="images/imgs/waves.png" class='d-line-block-align-text-top'> 
      </a>
      Water Front Property: Help
    </h1>
  </header>

  <div class= "navigation">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      
      <a href='index.php'>Home</a>
      |
      <a href='fileManagement.php'>File Management</a>
      
    </nav>
  </div>
  <div class= "navigation">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      
      <a href=#description>Description</a>
      |
      <a href=#checklist>Checklist</a>
      |
      <a href=#css>CSS</a>
      |
      <a href=#usage>Usage</a>
    </nav>
  </div>
  <div>
    <div class="description" id="description">
        <h3 calss="headHelp"> Description </h2>
        <p>
        Kevin Chamberlain: CSC-468-M01<br>
        GUI Web Project<br>
        This web application is meant to simulate the placement of realestate on waterfront properties<br>
        The website consists of a home page where users can place buidlings suchs as: hotels, homes, rentals, restaurants, or stores though the use of a dropdown menu<br>
        If space runs out along the water front a new row of buildings can be placed to accomodate more buildings. <br>
        If no decision can be made on the order there are preconfigured options, them being 'All Hotels' and 'Mixed'. <br>
        These are accompanied by your standard formatting operators. <br>
        This simulation is meant to be able to be saved, exported, and imported to save building plans. This is facilitated by the 'File Management' page of the application <br>      
        Finally we have the help page which you are currently on. If you get too far down in your reading feel free to click your sections header and it will send you back to the top.<br>
        This application is meant to show our learned skills about the Undo/Redo pattern using OOP, as well as our ability to save, load, and upload from the server. <br>
        The languages used to accomplish these tasks were: JavaScript, PHP, HTML, & CSS</p>
    </div>

    <div class="checklist" id="checklist">
      <a classname='navbar-brand' href=#description >
      <h3> Checklist:</h3>
      </a>

      <p>_X_ *Grading tags completed<p>
      <p>Undo/redo pattern (tier-less)**	35</p>
      <p>__X_ a. Undo/redo OOP followed (-50% for 1 moderate error)	7</p>
      <p> _X__ b. Able to do at least 1 undo/redo for 1 lot change (50% each)	7</p>
      <p>__X_ c. Able to do at least 1 undo/redo for 1 preconfigured change (50% each)	7</p>
      <p>__X_ d. Able to do at least 5 undo/redo for 1 piece change (50% each)	7</p>
      <p>__X_ f. Able to do at least 5 undo/redo for 1 preconfigured change (50% each)	7</p>
      
      <p>1.	Tier: Basic content	36</p>
      <p>__X__ a. All 3 pages present	</p>
      <p>__X_ b. Header in all pages in correct spot	</p>
      <p>__X__ c. Nav bar in all pages in correct spot	</p>
      <p>__X_ d. All interaction buttons added to main page in correct spot	</p>
      <p>__X_ e. Properly display the default content in main page in correct spot	</p>
      <p>__X_ f. At minimum, a place holder for file upload/load/download in file page in correct spot</p>	
      <p>__X_ h. All headings added to Help page in correct order	</p>
      <p>__X_ i. Help page content filled in	</p>
      <p>__X_ j. Within page link help page working	</p>

      <p>2a. Basic application tasks	20</p>
      <p>__X_ a. Able to change at least 1 building	</p>
      <p>__X_ b. Able to change at every building in the first row	</p>
      <p>__X_ c. Able to add a new row	</p>
      <p>__X_ d. Able to edit all buildings in the last row (-50% if any not working)	</p>

      <p>2b. CSS rules*	24</p>
      <p>__X_ a. Background color/image	</p>
      <p>__X_ b. CSS header	</p>
      <p>__X_ c. CSS nav bar color/image	</p>
      <p>__X_ d. CSS a tag rule	</p>
      <p>__X_ f. Content border	</p>
      <p>__X_ g. Help heading font change	</p>

      <p>3a More advanced main page options *	15</p>
      <p>__X_ a. Able to change to at least one preconfigured option	</p>
      <p>__X_ b. Able to change to any preconfigured options	</p>
      <p>__X_ c. Main content area unaffected by save, and stays on page 	</p>

      <p>3b Tier: Files	40</p>
      <p> __X_ a. Able to save the current content (must show in file page)	</p>
      <p>__X_ c. Able to download at least one file (default is ok)	</p>
      <p>__X_ d. Able to download an application generated file	</p>
      <p>__X_ e. Able to upload a file	</p>
      <p>__X_ f. Loading a file redirects back to the main page	</p>
      <p>__X_ g. Loading properly displays with some file (must be given with submission, if the app generated does not work)	</p>
      <p>__X_ h. Loading properly displays with app generated file</p>
      <p>__X_ i. Able to save, download, upload, and load that same file</p>

      <p>4 Tier: Extensions	30</p>
      <p>Extension 1: 2a, 5:points, Allow all buidlings to be editable: To test go to main page add multiple rows and attempt to change any.</p>
      <p>Extension 2: 2e, 5:points, Allow 2 files to be saved/loaded/ect. on server: On main page save configuration. Then go to File Management <br>
       where you will see the file. You will also be able to upload a file and download or load either file </p>
      <p>Extension 3: 2i, 5:points, Add standard form selections for buildings: On main page you will see dropdowns under the icons, those will switch the buildings.</p> 
      <p>Extension 4: 3a, 5:points, Make 3+ more buildings options available: On main page in the dropdown 'Rental','Restaurant'and'Store' options have been added. </p>
      <p>Extension 5: 3b, 10:points, Add images rather than text to indicate the building type. (Extra 5:points added for 3+ images to go with): On main page</p>
      <p> cycle through options and see images for every option selected. </p>
      <p>Total points for extensions: 30</p>

    </div>
    
    <div class="css" id="css">
    <a calss="headHelp" classname='navbar-brand' href=#description > 
        <h3> CSS </h3>
    </a>
    <p> Bootstrap used, specifically to shape/style buttons and navigation bar. </p>
    <p> Background of html page modified to a standard shape of blue accross the application, whereas dark blue was selected for header</p>
    <p> All text color for paragraphs and headers was changed to white for contrast. </p>
    <p> The a tag rule was made so that the color of the text was changed to black </p>
    <p> The headers for each page were centered for aesthetics. </p>
    <p> The background color of the navigation bars were changed to grey, the font-size was also adjusted for aesthetics. </p>
    <p> A horizontal row was used for the 'water', it's border was set to dashed and color set to light blue for constrast. </p>
    <p> A border was added around the content area, though for aesthetics it would've been better without. The background was changed to match the navigation bar</p>
    <p> The content area was adjusted so as to not take up the entire screen. </p>
    <p> The headers of the help page were changed to the font family 'serif' and the font-style was changed to italics for a more obvious change. </p>
    <p> All text not required to be changed had the font-family 'Lato' sans-serif </p>
    <p> Most other css changes made hade to do with alignment or sizing. </p>
    <p> Every page has a custom header included in every page. </p>
    <p> These changes can be found coded in the style.css file, if using inspector(FireFox) or elements(GoogleChrome) most often this file apears at the very bottom. </p>
    </div>
    
    <div class="usage" id="usage">
        <a calss="headHelp" classname='navbar-brand' href=#description > 
            <h3> Usage </h3>
        </a>
        
        <p> To use the main page of the applicatoin simply use dropdown to select the type of building you would like to place. <br>
            If you run out of room in a row you can add another row. CAUTION!!! deleting a row is an extension and therefore once you place a row you cannot undo it unless you reset. <br>
            Using the 'Save' button will save your current configuration as a txt file labeled and will save your configuration in the application, clearing your undo/redos<br>
            Using the 'Reset" button will reset your configuration to the default and clear your undo/redos. <br>
            Using the 'All Hotels' button will set your last row added to all hotel icons. <br>
            Using the 'Mixed' button will set your first two rows to the required configuration <br>
            Undo and Redo are self explanatory.<br>
            The File Management page is also self explanatory. Download will download that file to your computer, Load will load your configuration to the main application and take you there. <br>
            On the Help Page not only can you click the section names at the top and have them bring you to the section in page, but also if you click the heading of the section it will bring you back to the top of the page. <br>
            You can reach any page through the nav bar and the standard of clicking the company icon and having it return your to the home page has been added.<br>
            Throughout creation, there were times when the table wouldn't populate upon initilization. This problem has not happened since completion even after spamming refresh and reset. </p>
    <div>
  </div>

</body>