println("hello world"+args(0))
var i=0;
while(i<args.length){
	if(i!=0){
		print( " ")
	}
	print(args(i))
	
	i+=1;
	if(i>=args.length)
		println();
}

args.foreach(a=>{print(a)})