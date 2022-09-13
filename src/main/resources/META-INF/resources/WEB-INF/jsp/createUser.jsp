<html lang="en" coupert-item="9AF8D9A4E502F3784AD24272D81F0381"><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Goal Quest login</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
    <style>
        body {
            background: #1c1414;
            color: whitesmoke;
        }
    </style></head>
<body>
<div class="container">
    <form class="form-signin" method="post" action="/createUser">
        <h2 class="form-signin-heading">Welcome to Goal Quest</h2>
        <h3 class="form-signin-heading"> We just need the following information to get started</h3>
        <p>
            <label for="firstname" class="sr-only">tell us your first name</label>
            <input type="text" id="firstname" name="firstname" class="form-control" placeholder="firstname" required="" autofocus="">
        </p>
        <p>
            <label for="lastname" class="sr-only">tell us your last name</label>
            <input type="text" id="lastname" name="lastname" class="form-control" placeholder="lastname" required="" autofocus="">
        </p>
        <p>
            <label for="username" class="sr-only">create Username</label>
            <input type="text" id="username" name="username" class="form-control" placeholder="Username" required="" autofocus="">
        </p>
        <p>
            <label for="email" class="sr-only">create Username</label>
            <input type="email" id="email" name="email" class="form-control" placeholder="enter your email" required="" autofocus="">
        </p>
        <p>
            <label for="password" class="sr-only">Create password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required="">
        </p>
        <p>
            <label for="passwordconfirm" class="sr-only">confirm password</label>
            <input type="password" id="passwordconfirm" name="passwordconfirm" class="form-control" placeholder="confirm password" required="">
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form>
</div>
</body><div id="3a8e25a2-58ae-49fa-bb49-06e922de4e04" style="display: block !important; z-index: 2147483647 !important;"></div></html>