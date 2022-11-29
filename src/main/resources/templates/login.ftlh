<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Log In</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="../static/css/style.css">
</head>
<body>
    <div>
        <form action="/login" method="post">
            <div>
                <label>
                    Email: <input type="text" name="email">
                </label>
            </div>
            <div>
                <label>
                    Password: <input type="password" name="password">
                </label>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <div>
                <input type="submit" value="Sign In"/>
            </div>
        </form>
        <a href="/register">Add new user</a>
    </div>
</body>
</html>