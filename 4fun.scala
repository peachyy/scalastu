
//简单的函数式编程
/*
def printlnArgs(args: Array[String]):Unit={
	args.foreach(println);
}
printlnArgs(args)
println("-----------------")
def formatArgs(args:Array[String])= args.mkString("fff")

println(formatArgs(Array("z","n"," t f")))
*/
import scala.io.Source

if(args.length>0){
	for(line<-Source.fromFile(args(0)).getLines)
		//print(line.length+" "+line)
		widthOfLength(line);
	}
else
Console.err.println("请输入文件名")

def widthOfLength(s:String):Int={
 //println(s);
 println("xx"+s.length+"---toStringLength:"+s.length.toString.length)
 s.length
}
