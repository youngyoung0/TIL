resource "aws_s3_bucket" "appbucket" {
  bucket        = "${var.project_env}-sesac-app-bucket-2023"
  force_destroy = true




  tags = local.resource_tags
}


resource "aws_s3_bucket_policy" "cdn_allow" {
  bucket = aws_s3_bucket.appbucket.id
  policy = <<EOF

  {
    "Version": "2008-10-17",
    "Id": "PolicyForCloudFrontPrivateContent",
    "Statement": [
        {
            "Sid": "1",
            "Effect": "Allow",
                "Principal": {
                    "Service": "cloudfront.amazonaws.com"
                },
                "Action": "s3:GetObject",
                "Resource": "arn:aws:s3:::${aws_s3_bucket.appbucket.bucket}/converted/*",
                "Condition": {
                    "StringEquals": {
                      "AWS:SourceArn": "${aws_cloudfront_distribution.cdn_distribution.arn}"
                    }
          }},
            {
      "Sid": "Access-to-specific-VPCE-only",
      "Effect": "Deny",
      "Principal": "*",
      "Action": "s3:PutObject",
      "Resource":  "arn:aws:s3:::${aws_s3_bucket.appbucket.bucket}/*",
      "Condition": {
        "StringNotEquals": {
          "aws:sourceVpce": "${aws_vpc_endpoint.s3.id}"
        }
      }
    }
    ]
}

EOF


}

resource "aws_s3_bucket_lifecycle_configuration" "originDeleteRule" {
  bucket = aws_s3_bucket.appbucket.id

  rule {
    id = "OriginDelRule"

    filter {
      prefix = "orgin/"
    }
    expiration {
      days = 5
    }

    status = "Enabled"
  }
}