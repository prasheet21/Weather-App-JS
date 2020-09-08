
let tasks = ["I have to cook food" , "I have to take bath"]
let tasksCompleted = [] ;

const createTask = (task , count) => {
    var parentUL = document.querySelector(".list-body") ;

    var list = document.createElement('li') ;
    var bulletIcn = document.createElement("i") ; 
    bulletIcn.className = "fas fa-angle-right fa-lg" ;
    var hiddenCount = document.createElement("input") ;
    hiddenCount.id = "sno" ;
    hiddenCount.type = "hidden" ;
    hiddenCount.value = count ;
    var taskText = document.createElement("p") ;
    taskText.id = "content" ;
    taskText.innerHTML = task ;
    var divBtn = document.createElement("div") ;
    divBtn.className = "btns" ;
    var checkIcn = document.createElement("i") ;
    checkIcn.className = "fas fa-check" ;
    var remIcn = document.createElement("i") ;
    remIcn.className = "far fa-trash-alt" ;

    if (count == 0 && count != tasks.length-1){
        var downIcn = document.createElement("i") ;
        downIcn.className = "fas fa-angle-double-down" ;

        downIcn.setAttribute('onclick' , "shiftDown(this)") ;
        divBtn.append(downIcn) ;
    }else if (count != 0 && count == tasks.length-1){
        var upIcn = document.createElement("i") ;
        upIcn.className = "fas fa-angle-double-up" ;

        upIcn.setAttribute('onclick' , "shiftUp(this)") ;
        divBtn.append(upIcn) ;
    }else {
        var upIcn = document.createElement("i") ;
        upIcn.className = "fas fa-angle-double-up" ;
        var downIcn = document.createElement("i") ;
        downIcn.className = "fas fa-angle-double-down" ;

        upIcn.setAttribute('onclick' , "shiftUp(this)") ;
        downIcn.setAttribute('onclick' , "shiftDown(this)") ;

        divBtn.append(upIcn) ;
        divBtn.append(downIcn) ;
    }

    

    

    divBtn.append(hiddenCount) ;
    
    divBtn.append(checkIcn) ;
    divBtn.append(remIcn) ;

    list.append(bulletIcn) ;
    list.append(taskText) ;
    list.append(divBtn) ;

    parentUL.append(list) ;

   
    remIcn.setAttribute('onclick' , "deleteElement(this)") ;
    checkIcn.setAttribute('onclick' , "taskCompleted(this)") ;

}

const createCompletedTask = (task , count) => {
    var parentUL = document.querySelector(".list-body") ;

    var list = document.createElement('li') ;
    var bulletIcn = document.createElement("i") ; 
    bulletIcn.className = "fas fa-angle-right fa-lg" ;
    var hiddenCount = document.createElement("input") ;
    hiddenCount.id = "sno" ;
    hiddenCount.type = "hidden" ;
    hiddenCount.value = count ;
    var taskText = document.createElement("p") ;
    taskText.id = "content" ;
    taskText.innerHTML = `<del style = "color:red">${task}</del>` ;
    list.style.opacity = "0.6" ;
    var divBtn = document.createElement("div") ;
    divBtn.className = "btns" ;
    divBtn.style.width = "9.2%" ;
    var upIcn = document.createElement("i") ;
    upIcn.className = "fas fa-chevron-up" ;
    var downIcn = document.createElement("i") ;
    downIcn.className = "fas fa-chevron-down" ;
    var checkIcn = document.createElement("i") ;
    checkIcn.className = "fas fa-check" ;
    var remIcn = document.createElement("i") ;
    remIcn.className = "far fa-trash-alt" ;

    divBtn.append(hiddenCount) ;
    divBtn.append(checkIcn) ;
    divBtn.append(remIcn) ;

    list.append(bulletIcn) ;
    list.append(taskText) ;
    list.append(divBtn) ;

    parentUL.append(list) ;

    remIcn.setAttribute('onclick' , "deleteElement(this)") ;
    checkIcn.setAttribute('onclick' , "taskCompleted(this)") ;

}

const printTasks = () => {
    document.querySelector(".list-body").innerHTML = "" ;
    var i = 0 ;
    for (task of tasks){
        if (task != undefined){
            if (tasksCompleted.includes(task)){
                createCompletedTask(task , i) ;
            }else{
                createTask(task , i) ;
            }
        }
        i = i + 1 ;
    }
}

const shiftUp = (ref) => {
    var toBeShiftedUp = ref.parentNode.querySelector("#sno").value ;
    if (toBeShiftedUp > 0){
        var tempVar = tasks[toBeShiftedUp-1] ;
        tasks[toBeShiftedUp-1] =  ref.parentNode.parentNode.querySelector("#content").innerHTML ;
        tasks[toBeShiftedUp] = tempVar ;
    }
    printTasks() ;

}

const shiftDown = (ref) => {
    var toBeShiftedDown = parseInt(ref.parentNode.querySelector("#sno").value) ;
    if (toBeShiftedDown < tasks.length-1){
        var tempVar = tasks[toBeShiftedDown+1] ;
        tasks[toBeShiftedDown+1] = ref.parentNode.parentNode.querySelector("#content").innerHTML ;
        tasks[toBeShiftedDown] = tempVar ;
    }
    printTasks() ;
}

const deleteElement = (ref) => {
    var index = ref.parentNode.querySelector("#sno").value ;
    delete tasks[index] ;
    document.querySelector(".list-body").innerHTML = "" ;
    printTasks() ;
}

const taskCompleted = (ref) => {
    var text = ref.parentNode.parentNode.querySelector("#content") ;
    tasksCompleted.push(text.innerHTML) ;
    printTasks() ;
    console.log(tasksCompleted) ;
    console.log(tasks) ;
}

const addNewTask = (newTask) => {
    if(newTask.trim() === "")
    {
        alert("Task cannot be empty ... Please enter something ... !!!") ;
        document.getElementById("taskInput").value = "" ;
        document.getElementById("taskInput").placeholder = "Add New Task ..." ;
    }else{
        document.getElementById("taskInput").value = "" ;
        document.getElementById("taskInput").placeholder = "Add New Task ..." ;
        tasks.unshift(newTask) ;
        printTasks() ;
    }
    
    
}

(() => {
    printTasks() ;
})() ;