variable "aws_region" {
  type        = string
  description = "AWS region for the ECR repository"
}

variable "repository_name" {
  type        = string
  description = "Name of the ECR repository"
}

variable "image_tag_mutability" {
  default     = "MUTABLE"
  description = "Tag mutability setting of the repository"
}

variable "branch" {
  type        = string
  description = "Branch of project to pull docker image"
}

variable "lb_url" {
  type        = string
  description = "ALB url"
}
