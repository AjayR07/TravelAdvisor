<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;1,100;1,300;1,400;1,500&display=swap" rel="stylesheet">
​
    <style>
        *{margin:0;padding:0}body{font-family:Roboto,sans-serif}.border{padding:10vh 40vh;background-color:#f0f2f5}.page{height:1240px;width:874;background-color:#fff;padding:40px 50px;border-top:8px solid #3aabf0;border-bottom:8px solid #3aabf0}.text-right{text-align:right}.table table tr td{border-bottom:1px solid #f0f0f0}.table table tr{margin:0 0;padding:0 0}th{text-align:left}thead tr td{background:#000;color:#fff}td,th{padding:10px 8px;font-size:14px}h1,h2,h3,h4,h5,h6{font-weight:500}.shadow{box-shadow:0 4px 8px 0 rgba(0,0,0,.2),0 6px 20px 0 rgba(0,0,0,.19)}.footer{position:relative;bottom:0;left:0}p{line-height:1.5;font-size:14px}.mt-0{margin-top:0}.mt-1{margin-top:.25rem}.mt-2{margin-top:.5rem}.mt-3{margin-top:.75rem}.mt-4{margin-top:1rem}.mt-5{margin-top:1.5rem}.mt-0{margin-top:0}.mb-0{margin-bottom:0}.mb-1{margin-bottom:.25rem}.mb-2{margin-bottom:.5rem}.mb-3{margin-bottom:.75rem}.mb-4{margin-bottom:1rem}.mb-5{margin-bottom:1.25rem}.mx-1{margin-left:.25rem;margin-right:.25rem}.mx-2{margin-left:.5rem;margin-right:.5rem}.mx-3{margin-left:.75rem;margin-right:.75rem}.mx-4{margin-left:1rem;margin-right:1rem}.mx-5{margin-left:1.25rem;margin-right:1.25rem}.w-100{width:100%}.w-75{width:75%}.w-60{width:60%}.w-50{width:50%}.w-25{width:25%}.h-100{height:100%}.px-1{padding-left:.25rem;padding-right:.25rem}.px-2{padding-left:.5rem;padding-right:.5rem}.px-3{padding-left:.75rem;padding-right:.75rem}.px-4{margin-left:1rem;margin-right:1rem}.px-5{padding-left:1.25rem;padding-right:1.25rem}.py-1{padding-top:.25rem;padding-bottom:.25rem}.py-2{padding-top:.5rem;padding-bottom:.5rem}.py-3{padding-top:.75rem;padding-bottom:.75rem}.py-4{margin-top:1rem;margin-bottom:1rem}.py-5{padding-top:1.25rem;padding-bottom:1.25rem}.pt-1{padding-top:.25rem}.pt-2{padding-top:.5rem}.pt-3{padding-top:.75rem}.pt-4{margin-top:1rem}.pt-5{padding-top:1.25rem}.mt-10{margin-top:10px}.mt-20{margin-top:20px}.mt-30{margin-top:30px}.mt-40{margin-top:40px}.mt-50{margin-top:50px}.text-primary{color:#3aabf0}.text-secondary{color:#787878}.tr-secondary{background-color:#fafafa}.border-top{border-top:1px solid #e5e5e5}.table table tr td{border-bottom:1px solid #f0f0f0}
    </style>
</head>
<body>
        <div class="page shadow h-100">
            <div class="header">
                <table class="w-100">
                    <tr>
                        <td class="text-primary"><h1>${ val }</h1></td>
                        <td class="text-right">Invoice #${ val }</td>
                    </tr>
                </table>
            </div>
        </div>
</body>
</html>