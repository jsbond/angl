<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<body>
<section class="container">
    <div class="login">
        <h1>Admin part</h1>

        <form action="http://localhost:8080/users/login" method="POST">

            <p><input name = "email" type="text" value="" placeholder="view"></p>
            <p><input name = "password" type="password" value="" placeholder="view"></p>
            <p class="remember_me">
                <label>
                    <input type="checkbox" name="remember_me" id="remember_me">
                    Remember me on this computer
                </label>
            </p>
            <p class="submit"><input type="submit"></p>
        </form>
    </div>

</section>

</body>

</html>