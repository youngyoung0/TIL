variable "count_num" {
  default = 2
}
provider "aws" {
  profile = "inroes"
}


resource "aws_vpc" "vpc" {
  cidr_block = "172.16.0.0/16"
  tags = {
    env = "dev"
  }
}



resource "aws_subnet" "bastion_subnet" {
  count      = var.count_num
  vpc_id     = aws_vpc.vpc.id
  cidr_block = "172.16.${count.index}.0/24"

}

resource "aws_subnet" "db_subnet" {
  count      = var.count_num
  vpc_id     = aws_vpc.vpc.id
  cidr_block = "172.16.${count.index + (var.count_num * 2)}.0/24"


}

#internet gateway
resource "aws_internet_gateway" "igw" {
  vpc_id = aws_vpc.vpc.id
}



#nat gw
# resource "aws_nat_gateway" "nat_gw" {
#   allocation_id = aws_eip.nat_eip.id
#   subnet_id     = aws_subnet.bastion_subnet[0].id
#   depends_on    = [aws_internet_gateway.igw]

# }



# resource "aws_eip" "nat_eip" {

# }




#route table
resource "aws_route_table" "bastion_route_table" {
  vpc_id = aws_vpc.vpc.id
  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.igw.id
  }
  // tags = local.resource_tags
}


# resource "aws_route_table" "db_route_table" {
#   count  = var.count_num
#   vpc_id = aws_vpc.vpc.id
#   route {
#     cidr_block     = "0.0.0.0/0"

#   }
#   // tags = local.resource_tags
# }



#route_table_association
resource "aws_route_table_association" "bastion_subnet_route" {
  count          = var.count_num
  subnet_id      = aws_subnet.bastion_subnet[count.index].id
  route_table_id = aws_route_table.bastion_route_table.id
}




# resource "aws_route_table_association" "db_route_table" {
#   count          = var.count_num
#   subnet_id      = aws_subnet.db_subnet[count.index].id
#   route_table_id = aws_route_table.db_route_table[count.index].id
# }

output "name" {
  value = data.aws_caller_identity.current.account_id
}

data "aws_caller_identity" "current" {

}