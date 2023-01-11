class Table{
    buildings =['none','hotel','home','rental', 'restaurant', 'store'];
    

    constructor() {
        this.position = 0;
        this.rows = [];
        this.initialize();
        this.mix = false;
    }

    initialize() {
        let waterFront = document.createElement('table');
        waterFront.setAttribute('id', 'emptyTable');
        let icons = waterFront.insertRow(0);
        let dropDowns = waterFront.insertRow(1);
        this.setRow(waterFront, icons, dropDowns)

    }

    //Change
    addRow() {
        let empTab = document.getElementById('emptyTable');
        let rowCnt = empTab.rows.length;
        let imageRow = empTab.insertRow(rowCnt);
        let selectRow = empTab.insertRow(rowCnt+1);
        this.mix=true;
        this.setRow(empTab, imageRow, selectRow)

    }

    setRow(waterFront, icons, dropDowns) {
        for (let i=0; i<5; i++){

            const options = document.createElement('select');
            const tableData = document.createElement('td');
            
            options.setAttribute('onchange', 'setBuidling('+(this.position)+')');
            options.setAttribute('id','select'+this.position);
            options.innerHTML=" <option value=\"0\">None</option>\n"+
            " <option value=\"1\">Hotel</option>\n"+
            " <option value=\"2\">Home</option>\n"+
            " <option value=\"3\">Rental</option>\n"+
            " <option value=\"4\">Restaurant</option>\n"+
            " <option value=\"5\">Store</option>\n"

            
            tableData.appendChild(options);
            dropDowns.appendChild(tableData);

            var a = document.createElement('a');
            var img = document.createElement('img');
            var icon = document.createElement('td');

            a.setAttribute('id', 'type' + (this.position));
            img.setAttribute('src', 'images/imgs/none.png')
            img.setAttribute('id', 'icon'+(this.position));
            
            a.appendChild(img);
            icon.appendChild(a);
            icons.appendChild(icon);

            this.position++;
            this.rows.push('0');
        }

        let placement = document.getElementById('waterfront');
        placement.appendChild(waterFront);

    }

    save(){
        let size = this.rows.length;
        let cook;
        for(let i=0; i<size; i++){
            if(i===0){
                cook=this.rows[i]+',';
            }
            else{
                cook = cook +this.rows[i]+',';
            }
        }
        document.location.href = "save.php?content="+cook; 
        

    }

    
    selectBuilding(positions, value = '0',undo) {
        
        value = document.getElementById('select'+positions).value;
        let oldValue = this.rows[positions];
        if(!undo){
            hist.set(new UndoRedo(positions, value, oldValue));
        }
        
        switch(value){
            case '1':
                var img = document.getElementById('icon'+positions);
                img.setAttribute('src','images/imgs/hotel.png')
                this.rows[positions]="1";
                break;
            case '2':
                var img = document.getElementById('icon'+positions);
                img.setAttribute('src','images/imgs/home.png')
                this.rows[positions]="2";
                break;
            case '3':
                var img = document.getElementById('icon'+positions);
                img.setAttribute('src','images/imgs/rental.png')
                this.rows[positions]="3";
                break;
            case '4':
                var img = document.getElementById('icon'+positions);
                img.setAttribute('src','images/imgs/restaurant.png')
                this.rows[positions]="4";
                break;
            case '5':
                var img = document.getElementById('icon'+positions);
                img.setAttribute('src','images/imgs/store.png')
                this.rows[positions]="5";
                break;
            default:
                var img = document.getElementById('icon'+positions);
                img.setAttribute('src','images/imgs/none.png')
                this.rows[positions]="0";
                break;
            
        }
    
    }

    reset(){
        window.location.href="index.php";
    }

    hotels(notRedo = true){
        
        let currPos = (this.position-1);
        if(notRedo){
            let pos = this.rows.length / 5;
            hist.set(new UndoRedo(pos, 6, 0));
        }
        
        
        for (let i = 0; i < 5; i++) {
            let options = document.getElementById('select'+currPos);
            options.selectedIndex = 1;
            this.selectBuilding(currPos,'1',true);
            currPos --;
        }
        //how to get first index of the row I'm applying this to: Divide length of rows by five that will give you what row youre on//put this in positions spot
        //push special case cmd here
         //positions 0=row1 5=row2 10=row3...divisible by 5
        //value 6 meaning all hotels, 7 meaning mixed
        //save positions of row for redo
    }

    //taken from example
    undo(){
        hist.undoCmd();
    }

    //taken from example
    redo(){
        hist.redoCmd();
    }

    mixed(notRedo=true){

        if(notRedo){
            let pos;
            if(this.rows.length<10){
                pos = 0;
            }
            else{
                pos = 1;
            }
           
            hist.set(new UndoRedo(pos, 7, 0));
        }

        if(this.mix===false){
            this.addRow();
        }

        for(let i=0;i<9;i++){
            if(i===9){
                let options = document.getElementById('select'+i);
                options.selectedIndex = 0;
                this.selectBuilding(i,0,true); //true so state is not save in selectBuilding
            }
            else if((i===1||i===2||i===3||i===4||i===6||i===7)){
                let options = document.getElementById('select'+i);
                options.selectedIndex = 1;
                this.selectBuilding(i,1,true); 
            }
            else if(i===0||i===5||i===8){
                let options = document.getElementById('select'+i);
                options.selectedIndex = 2;
                this.selectBuilding(i,2,true);
            }
            
        }

        //value 6 meaning all hotels, 7 meaning mixed
    }

}

//GRADING: MANAGE
class History{

    constructor(){
        this.UndoRedos = [];
        this.index = 0;
        
    }

    //will have to change cmd to position and cmd
    //new UndoRedo, remove everything after the current UndoRedo index
	//and append the new function
   

    set(cmd){
        
        if(cmd.newValue===6){
           
            let currPos = (table.position-1);
            for (let i = 0; i < 5; i++) {
                
                
                cmd.hotelHist[i]=table.rows[currPos];
                currPos --;
            }

        }
        else if(cmd.newValue===7){
            let currPos = (table.position-1);
            let temp = currPos;
            for (let i = 0; i <= temp; i++) {
                
                cmd.mixedHist[i]=table.rows[currPos];
                currPos --;
            }
        }
        this.UndoRedos.push(cmd);
        this.index = this.UndoRedos.length;

    }

    
	//undo called. Call the undo functin on the current UndoRedo and move back one
    //GRADING: ACTION
    undoCmd(){
        if(this.index > 0){
            var cmd = this.UndoRedos[this.index-1];
            //value 6 meaning all hotels, 7 meaning mixed
            //save positions of row for redo
            //if all hotels set cmd to unused value send to special undo
            if(cmd.newValue === 6){
                cmd.hotelsUndo();
            }
            else if(cmd.newValue === 7){
                cmd.mixedUndo();
            }
            else{
                cmd.undo();
            }
            
            this.index= this.index-1;

        }
    }

    //redo called. Call the execution function on the current UndoRedo and move forward one
    redoCmd(){
        if(this.index < this.UndoRedos.length){
            var cmd = this.UndoRedos[this.index];
            if(cmd.newValue === 6){
                cmd.hotelsRedo();
            }
            else if (cmd.newValue === 7){
                cmd.mixedRedo();
            }
            else{
                cmd.exec();
            }
            
            this.index = this.index+1;
        }
    }

    //is undo available
    canUndo(){
        return this.index != 0;
    }

    //is redo available
    canRedo(){
        return this.index < this.UndoRedos.length;
    }
}

//GRADING: COMMAND
class UndoRedo{
    constructor(position, newValue, oldValue){ //change to position and value: HER: newVal Old,Val
        this.position = position;//need to store enought information to undo/redo
        this.newValue = newValue;
        this.oldValue = oldValue;
        this.hotelHist=[];
        this.mixedHist=[];
    }

    //appends the given letter to our result
    exec(){

        let options = document.getElementById('select'+this.position);
        options.selectedIndex = this.newValue;
        table.selectBuilding(this.position,this.newValue,true);
        
    }

    //removes a letter
    undo(){

        let options = document.getElementById('select'+this.position);
        options.selectedIndex = this.oldValue;
        table.selectBuilding(this.position,this.oldValue,true);
		
	}

    mixedUndo(){
        

        if(this.position===0){
            let tem = document.getElementById('emptyTable');
            let rowCnt = tem.rows.length-1;
            for(let i=0; i<2; i++){
                tem.deleteRow(rowCnt-i);
            }
            for(let j=0; j<5;j++){
                table.rows.pop();
            }
            table.position=5;
            
        }
        let currPos = (table.position-1);
        let temp = currPos;
        for (let i = 0; i <= temp; i++) {

            let options = document.getElementById('select'+currPos);
            let temp = this.mixedHist[i];
            options.selectedIndex = temp;
            table.selectBuilding(currPos,temp,true);
            currPos --;
        }   
        table.mix = false;
        
    }

    hotelsUndo(){
        let currPos = (table.position-1);
        for (let i = 0; i < 5; i++) {

            let options = document.getElementById('select'+currPos);
            let temp = this.hotelHist[i];
            options.selectedIndex = temp;
            table.selectBuilding(currPos,temp,true);
            currPos --;
        }    
    }

    mixedRedo(){
        table.mixed(false);
    }

    hotelsRedo(){
        table.hotels(false);
    }
}