
//List列表

val oneTwo=List(1,2);
val treeFour=List(3,4);
val oneTwoThree=oneTwo:::treeFour

println(""+oneTwo +" and " +treeFour +"fff");

println("oneTwoThree="+oneTwoThree+"ff")

var list1=List(1,2)
println("list1="+3::list1)
//加上::Nil是因为3个int类型 没有::方法
var list2=1::2::3::Nil
println("list2="+list2)
println("list2Length="+list2.length)