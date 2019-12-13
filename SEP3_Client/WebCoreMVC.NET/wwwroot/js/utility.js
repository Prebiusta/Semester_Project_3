//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Variables
//ID of the project client currently works on
var globalProjectID;
var globalSprintID;

//Goes to the last website loaded from the server 
function goToPreviousWebsite() {
    history.go(-1);
}

//Generic GET request function. Takes ID of the button, path to c# controller and a function that has to be called on a successful ajax call
function getGenericController(controllerPath, successFunction) {
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
function getUsersOutsideProject(projectID) {
    globalProjectID = projectID;
    getGenericController('/Members/GetUsersOutiseProjectJsonString?projectId=' + projectID, displayUsersOutsideProject);
    $('#addMemberModal').on('shown.bs.modal',
        function() {
            $('#myInput').trigger('focus')
        });
}


//Creates a list of users with possibility to add them to the project !!!!WARNING: Calls wrong method right now so it adds user but also redirects you. Instead of "PostMember" it should call c# function that doesn't change the view. REMEMBER to delete the line with suer after deleting him. You can also refresh entire list although it is 2/10
function displayUsersOutsideProject(json) {
    let list = "<ul id='listMember'>";
    for (var i = 0; i < json.length; i++) {
        var obj = json[i];
        list += '<li id="listMember' + i + '">';
        list += '<div class=\'structureModal\'>';
        list += '<div class="add_member_div">' + '<img src="https://yt3.ggpht.com/-v6ueJEAFe5E/AAAAAAAAAAI/AAAAAAAAAAA/QexJ3Y8Xxtc/s-c-k-no-rj-c0xffffffphoto.jpg" alt="red">';
        list += '<div class="add_member_info">';
        list += '<div class="column">';
        list += '<p class="member_name">' + obj['firstName']  + ' ' + obj['lastName'] + '</p>';
        list += '<p class="username">' + obj['username'] + '</p>';
        list += '</div>';
        list += '</div>';
        list += '<div class="member_buttons">';
        list += '<button class="addMemberButton w3-button w3-black w3-card-4" onclick="postMemberData(\'' + obj['username'] + '\', \'' + obj['firstName'] + '\', \'' + obj['lastName'] + '\', \'listMember' + i + '\')" > Add </button>';
        list += '</div>';
        list += '</div>';
        list += '</div>';
        list += '</li>'
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
                let newMember = '<div class="member">';
                newMember += '<img src="https://yt3.ggpht.com/-v6ueJEAFe5E/AAAAAAAAAAI/AAAAAAAAAAA/QexJ3Y8Xxtc/s-c-k-no-rj-c0xffffffphoto.jpg" alt="red"/>';
                newMember += '<div class="member_info" >';
                newMember += '<div class="column">';
                newMember += '<p>' + firstname + ' ' + lastname + '</p>';
                newMember += '<p class="username">' + username + '</p>';
                newMember += '<p class="text-success h6">User will be added to the project</p>';
                newMember += '</div>';
                newMember += '</div>';
                newMember += '<div class="member_buttons">';
                newMember += '<div class="column">';
                newMember += '<button class="detailsButton w3-button w3-black w3-card-4">Details</button>';
                newMember += '</div>';
                newMember += '</div>';
                //newMember += ' <button class="deleteMemberButton w3-button w3-black w3-card-4" onclick="deleteMemberFromTheProject(\'' + username + '\', ' + globalProjectID + ')">Delete member from the project</button>';
                newMember += '</div >';
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

function postAdmin(username) {
    let userProject = '"projectId":' + globalProjectID +', "username": ' + username;
    $.ajax({
        type: "POST",
        dataType: "json",
        url: '/Members/SendAdminDataJS?projectId=' + globalProjectID + '&username=' + username,
        contentType: 'application/json; charset=utf-8',
        headers: {
            RequestVerificationToken:
                $('input:hidden[name="__RequestVerificationToken"]').val()
        }
    });
}

//Deletes member from the project asynchronously
function deleteMemberFromTheProject(username, projectID) {
    $.ajax({
        type: "POST",
        dataType: "json",
        url: '/Members/DeleteMemberRequestJS?projectId=' + projectID + '&username=' + username,
        contentType: 'application/json; charset=utf-8',
        headers: {
            RequestVerificationToken:
                $('input:hidden[name="__RequestVerificationToken"]').val()
        },
        success: function (result, status, xhr) {
            if (result['status'] == 'ok') {
                $('#memberInTheProject' + username).remove();
            } else {
                document.getElementById("membersError").innerHTML = "Error while deleting a member. Try to refresh the website";
            }
        },
        error: function (xhr, status, error) {
            console.log("Result: " + status + " " + error + " " + xhr.status + " " + xhr.statusText)
        }
    });
}

//User story is added to project backlog and new item is displayed on the list
function addUserStoryToProjectBacklog(projectID) {
    let userStoryDescription = document.getElementById("projectUserStoryDescription").value;
    let userStoryPriority = document.getElementById("selectPriorityOfTheUserStory").value;
    let userStoryDifficulty = document.getElementById("selectDifficultyOfTheUserStory").value;

    $.ajax({
        type: "POST",
        dataType: "json",
        url: '/Backlog/AddUserStoryToProjectJS?userStoryId=-1&projectId=' + projectID + '&priority=' + userStoryPriority + '&description=' + userStoryDescription + '&difficulty=' + userStoryDifficulty + '&status=ONGOING',
        contentType: 'application/json; charset=utf-8',
        headers: {
            RequestVerificationToken:
                $('input:hidden[name="__RequestVerificationToken"]').val()
        },
        success: function (result, status, xhr) {
            console.log('success');
            if (result['status'] == 'ok') {
                let newUserStoryElement = '<li class="flex-row">';
                newUserStoryElement += '<p>' + userStoryDescription + '</p>';
                newUserStoryElement += '<p class="text-success h6 padding-left-30px">User story will be added to the project</p>';
                newUserStoryElement += '</li>';
                document.getElementById('listOfProjectUserStories').insertAdjacentHTML('afterbegin', newUserStoryElement);
                document.getElementById("projectUserStoryDescription").value = ' ';
                document.getElementById("selectPriorityOfTheUserStory").value = 'LOW';
                document.getElementById("selectDifficultyOfTheUserStory").value = '1';
            } else {
                document.getElementById("projectBacklogError").innerHTML = "Error while adding user story. Try to refresh the website";
            }
        },
        error: function (xhr, status, error) {
            console.log("Result: " + status + " " + error + " " + xhr.status + " " + xhr.statusText)
        }
    });
}

//NOT INTEGRATED WITH DATA LAYER YET. Loads all user stories from the project into sprint backlog view
function loadProjectUserStoriesIntoSprint(projectId, sprintID) {
    globalProjectID = projectId;
    globalSprintID = sprintID;
    getGenericController('/Backlog/GetUserStoriesForProjectJS?projectId=' + projectId, displayUserStoriesFromProject());
    
}

//Display user stories inside the modal
function displayUserStoriesFromProject(json) {
    let list = '<ul id="listOfProjectUserStories">';

    for (var i = 0; i < json.length; i++) {
        var obj = json[i];
        list += '<li class="flex-row">';
        list += '<p>' + obj['description'] + '</p>';
        list += '<p class="text-info padding-left-30px">Priority: ' +obj['priority'] + ', Difficulty: ' + obj['difficulty'] + '</p>';
        list += '<button class="btn btn-primary" onclick="assignUserStoryToSprint(' + obj + ')">Assign user story</button>'
        list += '</li>'
    }
    list += '</ul>';
    document.getElementById("addMembersDiv").innerHTML = list;
}

//Assigns user story to the sprint 
function assignUserStoryToSprint(jsonSprint) {
    $.ajax({
        type: "POST",
        dataType: "json",
        url: '/Sprint/AssignUserStoryToSprintJS?userStoryId=' + jsonSprint['userStoryId'] + '&sprintId=' + globalSprintID,
        contentType: 'application/json; charset=utf-8',
        headers: {
            RequestVerificationToken:
                $('input:hidden[name="__RequestVerificationToken"]').val()
        },
        success: function (result, status, xhr) {
            console.log('success');
            if (result['status'] == 'ok') {
                let newUserStoryElement = '<li class="flex-row">';
                newUserStoryElement += '<p>' + jsonSprint['description'] + '</p>';
                newUserStoryElement += '<p class="text-success h6 padding-left-30px">User story will be assigned to the sprint</p>';
                newUserStoryElement += '</li>';
                document.getElementById('listOfSprinttUserStories').insertAdjacentHTML('afterbegin', newUserStoryElement);
            } else {
                document.getElementById("projectBacklogError").innerHTML = "Error while adding user story. Try to refresh the website";
            }
        },
        error: function (xhr, status, error) {
            console.log("Result: " + status + " " + error + " " + xhr.status + " " + xhr.statusText)
        }
    });
}

// function displayUsersInProject(json) {
//     let list = "<ul";
//     for (var i = 0; i < json.length; i++) {
//         var obj = json[i];
//         list += '<option>' + obj['firstName'] + ' ' + obj['lastName'] + '</option';
//     }
//     list += '</ul>';
//     document.getElementById("assignProductOwner").innerHTML = list;
// }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Garbage/test code environment
function testButton() {
    console.log("test button clicked");
}
 

