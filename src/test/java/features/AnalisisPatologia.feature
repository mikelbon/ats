Feature: Analisis de Patologia

  Scenario Outline: Login de ATSalud correcto
    Given ATS ingresa a formulario Login y selecciona campo Usuario
    Then ATS ingresa su correo "demo12@gmail.com"
    When ATS selecciona campo Contraseña
    Then ATS ingresa su clave "123456"
    And ATS selecciona botón Ingresar
    When ATS selecciona la finca "CYBERNIUS"
    Then ATS visualiza todas las piscinas de la finca seleccionada
    When ATS elige la piscina "CY-01"
    Then se activa el boton Siguiente
    Then ATS visualiza el formulario Completa los datos
    When ATS ingresa los dias de cultivo "2"
    And ATS ingresa el peso "3" en gramos
    And ATS selecciona etapa de cultivo "Laboratorio"
    And ATS elige la unidad de medida "pl/g"
    And ATS ingresa el peso de siembra "4"
    And ATS presiona el boton Empezar
    Then ATS visualiza el formulario de analisis de Patologia
    When ATS ingresa analisis de organo "Hepatopáncreas"
    Then ATS ingresa datos del estudio de "<nombreEstudio>"
    And ATS ingresa valor de G1 "<G1>"
    And ATS ingresa valor de G2 "<G2>"
    And ATS ingresa valor de G3 "<G3>"
    And ATS ingresa valor de G4 "<G4>"
    And presiona el nombre del estudio "<nombreEstudio>" para minimizarlo
    When ATS agrega comentario del organo "El estudio del organo termino correctamente"
    When ATS ingresa los datos de lipidos "20%"
    And ATS presiona el boton Finalizar "Hepatopancreas"
    Then ATS visualiza el mensaje de confirmacion
    And ATS presiona el boton Tomar foto
    Then retornara al formulario anterior con la foto capturada en miniatura
    And ATS presiona el boton Finalizar "Hepatopancreas"
    Then ATS visualiza el formulario de analisis de Patologia con los simbolos de comentario y finalizado
    When ATS desliza el boton para finalizar
    Then ATS deberia visualizar la pantalla de analisis patologico terminado

    Examples:
      | nombreEstudio           | G1 | G2 | G3 | G4 |
      | Deformidad tubular      | 1  | 2  | 1  | 1  |
   #   | Melanizacion            | 1  | 1  | 1  | 1  |
  #    | Necrosis                | 1  | 1  | 1  | 1  |
  #    | Desprendimiento celular | 1  | 1  | 1  | 1  |









