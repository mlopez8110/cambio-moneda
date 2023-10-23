# cambio-moneda
api cambio de moneda

1. Tipo de cambio por moneda
   http://localhost:8087/api/cambio/monedaorigen/{monedaorigen}/monto/{monto}/monedafinal/{monedafinal}
   
2. Listar tipo de cambio
   
   http://localhost:8087/api/cambio/listatipocambio
   
4. Agregar Tipo cambio (Moneda Final Siempre sera SOL)
   
   http://localhost:8087/api/cambio/guadarcambio
   
   Body json:
   {
        "monedaorigen": "MXN",
        "monedafinal": "SOL",
        "tipocambio": 0.21
    }
   
6. Modificar Tipo de Cambio (Por ID)
   
   http://localhost:8087/api/cambio/updatecambio/{id}
   
      Body json:
    {
        "monedaorigen": "USD",
        "tipocambio": 3.967
    }
   
