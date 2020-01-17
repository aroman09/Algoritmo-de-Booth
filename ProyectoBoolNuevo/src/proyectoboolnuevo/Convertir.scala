/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectoboolnuevo



class Convertir (val Multiplicando:String, val Multiplicador:String, val numBits:String) {
  
  var proceso:String="\n\t\tALGORITMO DE BOOTH\n\n";
  var multiplicando :String = Multiplicando;
  var multiplicador :String = Multiplicador;
  
  def val_decimal(): java.lang.Boolean =       //cuando los valores son decimales
  {
    var n:java.lang.Boolean =true;
    this.proceso=this.proceso.concat("Multiplicando -> "+this.multiplicando+"\nMultiplicador -> "+this.multiplicador)
    this.proceso=this.proceso.concat("\n\nPrimer Paso: Pasamos de decimal a binario cada operando")
    if(Integer.parseInt(this.multiplicando)<0&&Integer.parseInt(this.multiplicador)<0)
    {
      this.proceso=this.proceso.concat("\n  *Si el multiplicando y multiplicador son negativos, se trabajara como valores positivos")
      //valores positivos
      this.multiplicando=(-1*(Integer.parseInt(this.multiplicando))).toString;
      this.multiplicador=(-1*(Integer.parseInt(this.multiplicador))).toString;
      this.proceso=this.proceso.concat("\n  Multiplicando -> "+this.multiplicando+"\n  Multiplicador -> "+this.multiplicador)
      //transforma decimal a binarios
      this.multiplicando=Integer.toBinaryString(Integer.parseInt(this.multiplicando));
      this.multiplicador=Integer.toBinaryString(Integer.parseInt(this.multiplicador));
      this.proceso=this.proceso.concat("\n\n Decimal a binario "+"\n  Multiplicando -> "+this.multiplicando+"\nMultiplicador -> "+this.multiplicador)
      this.proceso=this.proceso.concat("\n\nSegundo Paso: Completamos cada operando con el numero de bits especificado\n Numero de bits: "+this.numBits)
      n=completarBits
      this.proceso=this.proceso.concat("\n  Multiplicando -> "+this.multiplicando+"\n  Multiplicador -> "+this.multiplicador)
      if(n)
      {
        this.proceso=this.proceso.concat("\n\n*Al ser ambos valores negativos. Es necesario pasar a Complemento a 2 cada operando")
        //complemento A1
        this.multiplicando=complementoA1(this.multiplicando);
        this.multiplicador=complementoA1(this.multiplicador);
        this.proceso=this.proceso.concat("\n\nTercer Paso: Pasamos a Complemento a 1 cada operando")
        this.proceso=this.proceso.concat("\n\n Multiplicando -> "+this.multiplicando+"\n Multiplicador -> "+this.multiplicador)
        //complemento A2
        this.multiplicando=complementoA2(this.multiplicando);
        this.multiplicador=complementoA2(this.multiplicador);
        this.proceso=this.proceso.concat("\n\nCuarto Paso: Pasamos a Complemento a 2 cada operando")
        this.proceso=this.proceso.concat("\n\n Multiplicando -> "+this.multiplicando+"\n Multiplicador -> "+this.multiplicador)
      }
      
    }
    else if(Integer.parseInt(this.multiplicador)<0)
    {
      this.proceso=this.proceso.concat("\n  *Si el multiplicador es negativo, se trabajara como valor positivo")
      this.multiplicador=(-1*(Integer.parseInt(this.multiplicador))).toString;
      this.proceso=this.proceso.concat("\n  Multiplicador -> "+this.multiplicador)
      this.multiplicando=Integer.toBinaryString(Integer.parseInt(this.multiplicando));
      this.multiplicador=Integer.toBinaryString(Integer.parseInt(this.multiplicador));
      this.proceso=this.proceso.concat("\n\n Decimal a binario "+"\n  Multiplicando -> "+this.multiplicando+"\nMultiplicador -> "+this.multiplicador)
      this.proceso=this.proceso.concat("\n\nSegundo Paso: Completamos cada operando con el numero de bits especificado\n Numero de bits: "+this.numBits)
      
      n=completarBits
      this.proceso=this.proceso.concat("\n Multiplicando -> "+this.multiplicando+"\n Multiplicador -> "+this.multiplicador)
      if(n)
      {
        this.proceso=this.proceso.concat("\n\n*Al ser el multiplicador un numero negativo. Es necesario pasar a Complemento a 2.")
        //complemento A1
        this.multiplicador=complementoA1(this.multiplicador);
        this.proceso=this.proceso.concat("\n\nTercer Paso: Pasamos a Complemento a 1 el multiplicador")
        this.proceso=this.proceso.concat("\n\n Multiplicador -> "+this.multiplicador)
        //complemento A2
        this.multiplicador=complementoA2(this.multiplicador);
        this.proceso=this.proceso.concat("\n\nCuarto Paso: Pasamos a Complemento a 2 el multiplicador")
        this.proceso=this.proceso.concat("\n\n Multiplicador -> "+this.multiplicador)
      }
    }
    else if(Integer.parseInt(this.multiplicando)<0)
    {
      this.proceso=this.proceso.concat("\n  *Si el multiplicando es negativo, se trabajara como valor positivo")
      this.multiplicando=(-1*(Integer.parseInt(this.multiplicando))).toString;
      this.proceso=this.proceso.concat("\n  Multiplicando -> "+this.multiplicando)
      this.multiplicando=Integer.toBinaryString(Integer.parseInt(this.multiplicando));
      this.multiplicador=Integer.toBinaryString(Integer.parseInt(this.multiplicador));
      this.proceso=this.proceso.concat("\n\n Decimal a binario "+"\n  Multiplicando -> "+this.multiplicando+"\n Multiplicador -> "+this.multiplicador)
      this.proceso=this.proceso.concat("\n\nSegundo Paso: Completamos cada operando con el numero de bits especificado\n Numero de bits: "+this.numBits)
      
      n=completarBits
      this.proceso=this.proceso.concat("\n Multiplicando -> "+this.multiplicando+"\n Multiplicador -> "+this.multiplicador)
      if(n)
      {
        this.proceso=this.proceso.concat("\n\n*Al ser el multiplicando un numero negativo. Es necesario pasar a Complemento a 2.")
        //complemento A1
        this.multiplicando=complementoA1(this.multiplicando);
        this.proceso=this.proceso.concat("\n\nTercer Paso: Pasamos a Complemento a 1 el multiplicando")
        this.proceso=this.proceso.concat("\n\n Multiplicando -> "+this.multiplicando)
        //complemento A2
        this.multiplicando=complementoA2(this.multiplicando);
        this.proceso=this.proceso.concat("\n\nCuarto Paso: Pasamos a Complemento a 2 el multiplicando")
        this.proceso=this.proceso.concat("\n\n Multiplicando -> "+this.multiplicando)
      }
    }
    else
      {
        this.multiplicando=Integer.toBinaryString(Integer.parseInt(this.multiplicando));
        this.multiplicador=Integer.toBinaryString(Integer.parseInt(this.multiplicador));
        this.proceso=this.proceso.concat("\n Multiplicando -> "+this.multiplicando+"\n Multiplicador -> "+this.multiplicador)
        this.proceso=this.proceso.concat("\n\nSegundo Paso: Completamos cada operando con el numero de bits especificado\n\n Numero de bits = "+this.numBits)
        n=completarBits
        if(n)
          this.proceso=this.proceso.concat("\n Multiplicando -> "+this.multiplicando+"\n Multiplicador -> "+this.multiplicador)
      }
      
      return n
  }
  def val_binarios()                        //cuando son valores binarios solo completo bits
  {
    var a:Boolean=true;
    this.proceso=this.proceso.concat("Multiplicando -> "+this.multiplicando+"\nMultiplicador -> "+this.multiplicador)
    a=completarBits
    this.proceso=this.proceso.concat("\n\nPrimer Paso: Completamos los bits que faltan\n\n  Multiplicando -> "+this.multiplicando+"\n  Multiplicador -> "+this.multiplicador)
  }
  def completarBits():java.lang.Boolean=
  {
    var bits_relleno:String =""
    var i:Int =0
    print("\nnumero de bits en completar ",numBits,"   ",this.multiplicando.length)
    println("\nm1: ",this.multiplicando,"\nm2: ",this.multiplicador)
    if(this.multiplicando.length>Integer.parseInt(numBits)||this.multiplicador.length>Integer.parseInt(numBits))
    {
      println("if")
      return false
    }
    else
    {
      println("else")
      //completo bits del multiplicando
      for(i<-this.multiplicando.length to Integer.parseInt(this.numBits)-1)
      {
        bits_relleno+="0"
        print(i)
      }
      this.multiplicando=bits_relleno.concat(this.multiplicando)
      
      bits_relleno=""
      //completo bits del multiplicador
      for(i<-this.multiplicador.length to Integer.parseInt(this.numBits)-1)
      {
        print(i)
        bits_relleno+="0"
      } 
      this.multiplicador=bits_relleno.concat(this.multiplicador)
      println("\n Multiplicando -> "+this.multiplicando+"\nMultiplicador -> "+this.multiplicador)
      return true
    }
  }
  def complementoA1(m:String) : String =     //complemento a 1
  {
    var aux:String =""
    for (i <- 0 until Integer.parseInt(this.numBits))
    {
      if (m.charAt(i) == '1')
      {
          aux += "0";
      } else {
          aux += "1";
      }
    }
    return aux
  }
  def complementoA2(m:String):String =       //complemento a 2
  {
    var comp_1:Int = Integer.parseInt(m, 2);
    var comp_2:Int = comp_1 + 1;

    var bin_comp2:String = Integer.toBinaryString(comp_2);
    if (bin_comp2.length() > Integer.parseInt(this.numBits))    {
        bin_comp2 = bin_comp2.substring(1);
    }
    return bin_comp2;
  }
  def pasarAdecimal(m:String):String=
  {
    var num:Int=Integer.parseInt(m,2);
    return num.toString
  }
  def pasarAbinario(g:String):String=
  {
    var aux:String=g
    var n:String=""
    var i:Int=0
    if(Integer.parseInt(g)<0)
    {
      aux=(-1*(Integer.parseInt(g))).toString
    }
    aux=Integer.toBinaryString(Integer.parseInt(aux));
      for(i<-aux.length to Integer.parseInt(this.numBits)-1)
      {
        n+="0"
      }
      aux=n.concat(aux)
      println("paso a binario ",aux)
     return aux
  }
  def getM1():String =                      //devuelve el multiplicando
  {
    return this.multiplicando
  }
  def getM2():String =                      //devuelve el multiplicador
  {
    return this.multiplicador
  }
  def recup_proceso():String=               //proceso realizado
  {
    return this.proceso
  }
}
