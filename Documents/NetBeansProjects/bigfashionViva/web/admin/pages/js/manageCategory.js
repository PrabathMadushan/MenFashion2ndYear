$(document).ready(function () {
    loadCategories();
});

function saveCategory() {
    var name = $('#c-name').val();
    var des = $('#c-des').val();
    $.post("../../newCategory", {
        name: name,
        des: des
    }, (data, status) => {
        if (data === "false") {
            demo.showNotification('top','right','New Category Not Saved');
            loadCategories();
        } else {
            demo.showNotification('top','right','New Category '+name+' is Saved');
        }

    });
}

function loadCategories() {
    $.post("../../LoadCategories", null, (data, status) => {
        
        //document.getElementById("tblcategories").innerHTML=data;
        $("#tblcategories").html(data);

    });
}


