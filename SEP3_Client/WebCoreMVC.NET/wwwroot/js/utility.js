//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Variables
//ID of the project client currently works on
var globalProjectID;

//Goes to the last website loaded from the server 
function goToPreviousWebsite() {
    history.go(-1);
}

//Generic GET request function. Takes ID of the button, path to c# controller and a function that has to be called on a successful ajax call
function getGenericController(buttonID, controllerPath, successFunction) {
        $.ajax({
            type: "GET",
            url: controllerPath,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            async: "false",
            success: function (result, status, xhr) {
                successFunction(result);
            },
            error: function (xhr, status, error) {
                console.log("Result: " + status + " " + error + " " + xhr.status + " " + xhr.statusText)
            }
        });
        console.log("Button was clicked!");
        return false;
}

//Calls generic GET function to get all users outside the project and then calls a function to display all suers to the website. Assigns current projectID variable.
function getUsersOutsideProject(buttonID, projectID) {
    console.log('users outside project function called');
    globalProjectID = projectID;
    getGenericController(buttonID, '/Members/GetUsersOutiseProjectJsonString?projectId=' + projectID, displayUsersOutsideProject);
    $('#addMemberModal').on('shown.bs.modal', function () {
        $('#myInput').trigger('focus')
    })
}

//Creates a list of users with possibility to add them to the project !!!!WARNING: Calls wrong method right now so it adds user but also redirects you. Instead of "PostMember" it should call c# function that doesn't change the view. REMEMBER to delete the line with suer after deleting him. You can also refresh entire list although it is 2/10
function displayUsersOutsideProject(json) {
    let list = "<ul>";
    for (var i = 0; i < json.length; i++) {
        var obj = json[i];
        list += '<li id="listMember' + i + '">- <a onclick="postMemberData(\'' + obj['username'] + '\', \'' + obj['firstName'] + '\', \'' + obj['lastName'] + '\', \'listMember' + i + '\')" > ' + obj['username'] + '</a >' + ', ' + obj['firstName'] + ', ' + obj['lastName'] + "</li>";
    }
    list += '</ul>';
    document.getElementById("addMembersDiv").innerHTML = list;
}

//Asynchronously POST a member and delete him from the displayed list
function postMemberData(username, firstname, lastname, listID) {
    let userProject = '"projectId":' + globalProjectID +', "username": ' + username;
    $.ajax({
        type: "POST",
        dataType: "json",
        url: '/Members/SendMemberDataJS?projectId=' + globalProjectID + '&username=' + username,
        contentType: 'application/json; charset=utf-8',
        headers: {
            RequestVerificationToken:
                $('input:hidden[name="__RequestVerificationToken"]').val()
        },
        success: function (result, status, xhr) {
            console.log(userProject + ' , result: ' + result);
            console.log('success');
            if (result['status'] == 'ok') {
                $('#' + listID).remove();
                let newMember = '<li class="flex-row">';
                newMember += '<p>- ' + username + '   ' + firstname + ' ' + lastname + '</p > '
                newMember += ' <button class="deleteMemberButton w3-button w3-black w3-card-4" onclick="location.href=\'/Members/DeleteMember?projectId=' + globalProjectID + '&username=' + username + '\'">Delete member from the project</button>';
                newMember += '</li >';
                document.getElementById('membersInTheProjectList').insertAdjacentHTML('afterbegin', newMember);
            } else {
                document.getElementById("membersError").innerHTML = "Error while adding a member. Try to refresh the website"
            }
        },
        error: function (xhr, status, error) {
            console.log("Result: " + status + " " + error + " " + xhr.status + " " + xhr.statusText)
        }
    });
}

function deleteMemberFromTheProject() {
    $.ajax({
        type: "POST",
        dataType: "json",
        url: '/Members/SendMemberDataJS?projectId=' + globalProjectID + '&username=' + username,
        contentType: 'application/json; charset=utf-8',
        headers: {
            RequestVerificationToken:
                $('input:hidden[name="__RequestVerificationToken"]').val()
        },
        success: function (result, status, xhr) {
            if (result['status'] == 'ok') {
                $('#' + listID).remove();
                let newMember = '<li class="flex-row">';
                newMember += '<p>- ' + username + '   ' + firstname + ' ' + lastname + '</p > '
                newMember += ' <button class="deleteMemberButton w3-button w3-black w3-card-4" onclick="location.href=\'/Members/DeleteMember?projectId=' + globalProjectID + '&username=' + username + '\'">Delete member from the project</button>';
                newMember += '</li >';
                document.getElementById('membersInTheProjectList').insertAdjacentHTML('afterbegin', newMember);
            } else {
                document.getElementById("membersError").innerHTML = "Error while adding a member. Try to refresh the website"
            }
        },
        error: function (xhr, status, error) {
            console.log("Result: " + status + " " + error + " " + xhr.status + " " + xhr.statusText)
        }
    });
}


//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Garbage/test code environment
function testButton() {
    console.log("test button clicked");
}
 

