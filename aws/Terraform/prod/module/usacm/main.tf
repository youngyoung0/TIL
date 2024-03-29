provider "aws" {
  region = "us-east-1"
}
resource "aws_acm_certificate" "cdn_cert" {
  domain_name       = "*.${var.ourdomain}"
  validation_method = "DNS"

  lifecycle {
    create_before_destroy = true
  }
}



