    $(function() {
reload();
    });


    function reload() {
        const studentsContainer = $("#students");
        studentsContainer.html("");

        $.ajax({
      url: "students",
      method: 'GET',
      dataType: 'json',
      complete: content => {

    content.responseJSON.forEach(student => {
    let row = $(`<div>${student.name} : ${student.grade}</div>`)
    let button = $("<button>Delete</button>");
    button.click(function() {
        $.ajax({
      url: `students/${student.id}`,
      method: 'DELETE',
      complete: function() {
      reload();
      }
      }
      );
      return false;
      }
      );

      row.append(button);
      studentsContainer.append(row);
    }
    );

    }
    }
    );

      }