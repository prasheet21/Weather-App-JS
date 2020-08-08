
function clean_display() {
    document.getElementById("display").value = " " ;
}
function result() {

    var expression = document.getElementById("display").value ;
    console.log(expression) ;
    if ("=" == expression[1]) {
        expression = expression.slice(3) ;
    }
    console.log(expression) ;
    document.getElementById("display").value =" = " + eval(expression) ;
}

function insert(symbol){
    // var operators = "*-+." ;
    // var expression = document.getElementById("display").value ;
    // var previous_ele = expression[-1] ;
    // console.log(previous_ele) ;
    // if (operators.includes(symbol)){
    //     if (operators.includes(previous_ele)){
    //         console.log("includes ...") ;
    //     expression = expression.split("") ;
    //     console.log(expression)
    //     expression[-1] = symbol ;
    //     console.log(expression[-1])
    //     expression = expression.join("");
    //     console.log("expression : " + expression) ;
    //     }
    // } 
    var expression = document.getElementById("display").value ;
    
    document.getElementById("display").value = expression + symbol ;
}

(function(){
    document.getElementById("display").value = " " ;
})() ;

