<%-- 
    Document   : notFound
    Created on : 19 oct. 2016, 21:32:08
    Author     : mbds
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    </head>
    <body>


        <!-- Page Content -->
        <div class="container">

            <!-- Portfolio Item Heading -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Bonjour ${requestScope['nom']} ${requestScope['prenom']}</h1>
                </div>
            </div>
            <!-- /.row -->

            <!-- Portfolio Item Row -->
            <div class="row">

                <div class="col-md-5">
                    <img class="img-responsive" src="http://placehold.it/750x500" alt="">
                </div>

                <div class="col-md-4">
                    <h3>Produit du jour</h3>
                    <p>Le " ${requestScope['pdj_n']} "</p>
                    <label>Prix HT : </label><p> ${requestScope['pdj_p']} €</p>
                    <br>
                    <form>
                        <div class="form-group">
                            <label for="focusedInput">Quantité : </label>
                            <input class="form-control" id="focusedInput" type="text">
                        </div>
                        <button type="button" class="btn btn-primary">Ajouter le produit au panier</button>
                    </form>

                </div>

            </div>
            <!-- /.row -->

            <!-- Related Projects Row -->
            <div class="row">

                <div class="col-lg-12">
                    <h3 class="page-header">Autres produits</h3>
                </div>

                <div class="col-sm-3 col-xs-6">
                    <a href="#">
                        <img class="img-responsive portfolio-item" src="http://placehold.it/500x300" alt="">
                    </a>
                </div>

                <div class="col-sm-3 col-xs-6">
                    <a href="#">
                        <img class="img-responsive portfolio-item" src="http://placehold.it/500x300" alt="">
                    </a>
                </div>

                <div class="col-sm-3 col-xs-6">
                    <a href="#">
                        <img class="img-responsive portfolio-item" src="http://placehold.it/500x300" alt="">
                    </a>
                </div>

                <div class="col-sm-3 col-xs-6">
                    <a href="#">
                        <img class="img-responsive portfolio-item" src="http://placehold.it/500x300" alt="">
                    </a>
                </div>

            </div>
            <!-- /.row -->

            <hr>

            <!-- Footer -->
            <footer>
                <div class="row">
                    <div class="col-lg-12">
                        <p>Copyright &copy; Master MBDS </p>
                    </div>
                </div>
                <!-- /.row -->
            </footer>

        </div>
        <!-- /.container -->

        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>

    </body>
</html>
