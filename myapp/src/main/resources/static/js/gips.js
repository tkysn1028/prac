function Alert(){
/*
受け取ってID,NAME,PASSWORD2つの4つの値を受け取って空文字チェックする関数。内部で再度yellowcheck関数を呼び出している
*/
const checkKaramoji = (checkstr,checkstr2,checkstr3,checkstr4) =>{
    
    if(!checkstr.value){
        window.alert("failed id is null");
        yellowCheck(checkstr,checkstr2,checkstr3,checkstr4);
    }else if(!checkstr2.value){
        window.alert("failed name is null");
        yellowCheck(checkstr,checkstr2,checkstr3,checkstr4);
    }else if(!checkstr3.value){
        window.alert("failed pass is null");
        yellowCheck(checkstr,checkstr2,checkstr3,checkstr4);
    }else if(!checkstr4.value){
        window.alert("failed another pass is null");
        yellowCheck(checkstr,checkstr2,checkstr3,checkstr4);
    }else if(checkstr3.value == checkstr4.value){
        window.alert("failed not same pass");
    }else if(checkstr3.value.length < 10){

        window.alert("10文字以上でないといけません");
        yellowCheck(checkstr,checkstr2,checkstr3,checkstr4);
    }else{
        window.alert("login");
        yellowCheck(checkstr,checkstr2,checkstr3,checkstr4); 
    }
}
/*
ID,NAME,PASSWORD2つの4つの値を受け取って空のボックスの色を変える。
*/
const yellowCheck = (checkstr,checkstr2,checkstr3,checkstr4) =>{
    
    
    if(!checkstr.value){
    checkstr.style.backgroundColor = "#ff0000";
    }else{
        checkstr.style.backgroundColor = "#ffffff";
    }

    
    if(!checkstr2.value){
        checkstr2.style.backgroundColor = "#ff0000";
    }else{
        checkstr2.style.backgroundColor = "#ffffff";
    }

    
    if(!checkstr3.value){
        checkstr3.style.backgroundColor = "#ff0000";
    }else{
        checkstr3.style.backgroundColor = "#ffffff";
    }


    if(!checkstr4.value){
        checkstr4.style.backgroundColor = "#ff0000";
    }else{
        checkstr4.style.backgroundColor = "#ffffff";
    }
    
}

/*パラメタの定義*/
var id = document.getElementById("id");
var name = document.getElementById("name");
var pass = document.getElementById("pass");
var pass2 = document.getElementById("pass2");


/*空文字チェックの関数を呼び出し*/
checkKaramoji(id,name,pass,pass2);





}




