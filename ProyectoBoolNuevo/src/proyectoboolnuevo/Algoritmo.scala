/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectoboolnuevo


class Algoritmo (val Multiplicando:String , val Multiplicador:String, val Numbits:String,val tsigno:String ) {
  
  var multiplicando:String=Multiplicando
  var multiplicador:String=Multiplicador
  var numbits:Int=Integer.parseInt(Numbits)
  var p1:String=""
  var proceso:String=""
  var signo:String=tsigno
  var resultado = ""
  
  def operadorA():String=
  {
    var A:String=""
    A=rellenarBitsFinal(this.multiplicando)
    println("valor de A: ",A)
    return (A.concat("0"))
  }
  def operadorS():String=
  {
    var c=new Convertir(this.multiplicando,this.multiplicador,this.numbits.toString);
    var S:String=""
    S=c.complementoA1(this.multiplicando)
    S=rellenarbitsIniciales(S)
    println("Compl A1 s ",S)
    S=c.complementoA2(S)
    S=rellenarbitsIniciales(S)
    println("Compl A2 s ",S)
    S=rellenarBitsFinal(S)
    println("valor de S: ",S)
    return (S.concat("0"))
  }
  def operadorP():String=
  {
    var P1:String=""
    P1=rellenarBitsInicio(this.multiplicador)
    println("valor de P: ",P1)
    return (P1.concat("0"))
  }
  def booth()
  {
    println("valores m1 y m2 ",this.multiplicando,"  ",this.multiplicador)
    var i:Int=0
    var ultimos_digitos:String=""
    var a1=operadorA
    var s1=operadorS
    this.p1=operadorP
    var aux:String=""
    this.proceso=this.proceso.concat("\n\nTercer Paso: Determinador los bytes para A,S y P y completar el numero de bits al doble del especificado")
    this.proceso=this.proceso.concat("\n\n  * A esta formado por el multiplicando, el siguiente byte se forma con ceros y se agrega un bit extra que también es 0.")
    this.proceso=this.proceso.concat("\n\tA = "+a1)
    this.proceso=this.proceso.concat("\n\n  * S esta formado complemento A2 del multiplicando, el siguiente byte se forma con ceros y al final se agrega un bit extra que es 0.")
    this.proceso=this.proceso.concat("\n\tS = "+s1)
    this.proceso=this.proceso.concat("\n\n  * P esta formado por ceros, el siguiente byte es el valor del multiplicador y por ultimo se tiene el bit extra ")
    this.proceso=this.proceso.concat("\n\tP = "+this.p1)
    this.proceso=this.proceso.concat("\n\nCuarto Paso: consiste en comparar los ultimos dos digitos de P y dependiendo del caso que sea realizar un suma o no realizar")
    this.proceso=this.proceso.concat("\nninguna acción (desplazamiento). Luego de evaluar cada caso se debe realizar un corrimiento a la derecha, manteniendo el valor del")
    this.proceso=this.proceso.concat("\nbit más significativo y desechando el valor del bit menos significativo.")
    this.proceso=this.proceso.concat("\n\n  Los cuatro casos que se pueden ver son:\n\t* 0 0 -> Desplazamiento de P\n\t* 0 1 -> P = P + A\n\t* 1 0 -> P = P + S\n\t* 1 1 -> Desplazamiento de P")
    while(i<this.numbits)
    {
      println("\n\nEjecucion ",i)
      this.proceso=this.proceso.concat("\n\n  *Ejecucion "+(i+1))
      this.proceso=this.proceso.concat("\n\n\tP = "+this.p1)
      aux=""
      println("valor de P inicio:  ",this.p1)
        ultimos_digitos=this.p1.substring(this.p1.length -2)
        this.proceso=this.proceso.concat("\n\tUltimos digitos : "+ultimos_digitos)
        println(" ultidig ", ultimos_digitos)
        if(ultimos_digitos.equalsIgnoreCase("00")||ultimos_digitos.equalsIgnoreCase("11"))
        {
          this.proceso=this.proceso.concat("\n\n\t- Desplazamiento 1 bit a la derecha ")
           this.p1=(java.lang.Long.parseLong(this.p1,2)>>>1).toString
           println("pp1->",this.p1)
           this.p1=java.lang.Long.toBinaryString(java.lang.Long.parseLong(this.p1));
           println("pbin->",this.p1)
           this.p1=rellenarBitsInicio(this.p1)
           this.proceso=this.proceso.concat("\n\t P =          "+this.p1)
           bitBool()
           this.proceso=this.proceso.concat("\n\n\t- Se completa el bit desplazado\n\t P =          "+this.p1)
           println("pbool->",this.p1)
        }
        if(ultimos_digitos.equalsIgnoreCase("10"))
        {
          println("10")
          
        println("P = ",this.p1,"  P decimal ",java.lang.Long.parseLong(this.p1,2))
        println("S = ",s1,"  S decimal ",java.lang.Long.parseLong(s1,2))
           this.proceso=this.proceso.concat("\n\n\tP =          "+this.p1)
            this.proceso=this.proceso.concat("\n\tS =          "+s1)
          aux=(java.lang.Long.parseLong(this.p1,2)+java.lang.Long.parseLong(s1,2)).toString
          println("aux decimal ",aux)
          aux=java.lang.Long.toBinaryString(java.lang.Long.parseLong(aux));
          println("aux bin2->",aux)
          aux=rellenarBitsInicio(aux)
          if (aux.length>this.numbits*2+1)
            {
              aux=aux.substring(1)
              println("long aux2 ",aux.length)
            }
          this.proceso=this.proceso.concat("\n\tP = P+S "+aux)
          this.proceso=this.proceso.concat("\n\n\t- Desplazamiento 1 bit a la derecha ")
          aux=(java.lang.Long.parseLong(aux,2)>>>1).toString
          this.p1=java.lang.Long.toBinaryString(java.lang.Long.parseLong(aux))
          println("p+s->",this.p1)
          this.p1=rellenarBitsInicio(this.p1)
          this.proceso=this.proceso.concat("\n\tP =       "+this.p1)
          bitBool()
          this.proceso=this.proceso.concat("\n\n\t- Se completa el bit desplazado\n\t P =          "+this.p1)
          println("pbool->",this.p1)
        }
        if(ultimos_digitos.equalsIgnoreCase("01"))
        {
          println("01")
          
        println("P = ",this.p1,"  P decimal ",java.lang.Long.parseLong(this.p1,2))
        println("A = ",a1,"  A decimal ",java.lang.Long.parseLong(a1,2))
          this.proceso=this.proceso.concat("\n\n\tP =          "+this.p1)
          this.proceso=this.proceso.concat("\n\tA =          "+a1)
          aux=(java.lang.Long.parseLong(this.p1,2)+java.lang.Long.parseLong(a1,2)).toString
          println("aux decimal ",aux)
          aux=java.lang.Long.toBinaryString(java.lang.Long.parseLong(aux));
          println("aux bin3->",aux)
          aux=rellenarBitsInicio(aux)
          if (aux.length>this.numbits*2+1)
            {
              aux=aux.substring(1)
              println("long aux2 ",aux.length,"   aux ",aux)
            }
            this.proceso=this.proceso.concat("\n\tP = P+A "+aux)
            this.proceso=this.proceso.concat("\n\n\t- Desplazamiento 1 bit a la derecha ")
          aux=(java.lang.Long.parseLong(aux,2)>>>1).toString
          
          this.p1=java.lang.Long.toBinaryString(java.lang.Long.parseLong(aux))
          println("p+a->",this.p1)
          this.p1=rellenarBitsInicio(this.p1)
          this.proceso=this.proceso.concat("\n\tP =          "+this.p1)
          bitBool()
          this.proceso=this.proceso.concat("\n\n\t- Se completa el bit desplazado\n\t P =          "+this.p1)
          println("pbool->",this.p1)
        }
        i+=1
        print("i  ",i)        
    }
    numeroNegativo(this.p1)
  }
  def pasarAdecimal(m:String):String=
  {
    var num:Long=java.lang.Long.parseLong(m,2);
    return num.toString
  }
  def rellenarBitsFinal(mult:String):String =
  {
    var aux:String=""
    var mt=mult
    var tope:Int=2*this.numbits
    print("topeeeee ",tope)
    for(i<-mult.length to (tope-1))
    {
      aux+="0"
    }
    mt=mt.concat(aux)
    println("rellenar final: ",mt)
    return mt
  }
  def rellenarBitsInicio(mult:String):String =
  {
    var aux:String=""
    var mt=mult
    var tope:Int=2*this.numbits
    for(i<-mult.length to (tope-1))
    {
      aux+="0"
    }
    mt=aux.concat(mt)
    println("rellenar inicio: ",mt)
    return mt
  }
  def bitBool()
  {

    println("tamanio",this.p1 .length)
    if(this.p1.length <(this.numbits*2))
      {
        print("rellenando")
        rellenarP()
      }
      
    if(this.p1 .substring(0,1).equalsIgnoreCase("1"))
      this.p1 =("1").concat(this.p1)
    else
      this.p1 =("0").concat(this.p1 )
    println("bit bool ",this.p1 )
  }

  def rellenarP()
  {
    var relleno:String=""
    for(i<-this.p1.length to (this.numbits*2+1))
      {
        relleno=relleno.concat("0")
      }
      this.p1 =relleno.concat(this.p1 )
      println("RELLENAR P1: ",this.p1 )
  }
  def rellenarbitsIniciales(m:String):String=
  {
    var aux:String=""
    var mt=m
    for(i<-mt.length to (this.numbits-1))
    {
      aux+="0"
    }
    mt=aux.concat(mt)
    println("rellenar inicio: ",mt)
    return mt
  }
  def numeroNegativo(m:String)
  {
    var signo:Long=potencia(2*this.numbits)
    this.proceso=this.proceso.concat("\n\nFinalmente ignoramos el bit menos significativo y pasamos el valor de P a decimal y obtenemos el resultado")
    if(this.tsigno.equalsIgnoreCase("-"))
      {
        println("signo ",signo)
        this.proceso=this.proceso.concat("\n\tP          = "+m.substring(0, m.length-1))
        this.resultado=pasarAdecimal(m.substring(1,m.length-1))
        println("resultado decimal ",this.resultado)
        this.resultado=(-1*signo+java.lang.Long.parseLong(this.resultado)).toString
        println("valor final => ",this.resultado)
      }
    else
      {
        this.resultado=m.substring(0, m.length-1)
        this.proceso=this.proceso.concat("\n\tP          = "+this.resultado)
        this.resultado=pasarAdecimal(this.resultado)
      println("valor final=> ",this.resultado)
      }
    this.proceso=this.proceso.concat("\n\n\tResultado = "+this.resultado)
  }
  def potencia(exp:Int):Long=
  {
    var res:Long=1
    for(i<-1 to exp-1)
      {
        res=res*2
      }
      
      return res
  }
  def getResultado():String=
    {
      return this.resultado
    }
  def getProceso():String=
    {
      return this.proceso
    }
}
