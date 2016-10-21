namespace Projeto_Integrado_A_
{
    partial class Projeto_Integrado_A_v2
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Projeto_Integrado_A_v2));
            this.LBLnum = new System.Windows.Forms.Label();
            this.TXTent = new System.Windows.Forms.TextBox();
            this.BUTvap = new System.Windows.Forms.Button();
            this.BUTlimp = new System.Windows.Forms.Button();
            this.LBLconsulta = new System.Windows.Forms.Label();
            this.TXTconsult = new System.Windows.Forms.TextBox();
            this.BUTcons = new System.Windows.Forms.Button();
            this.BUTregras = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.BUTlistaapst = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // LBLnum
            // 
            this.LBLnum.AutoSize = true;
            this.LBLnum.BackColor = System.Drawing.Color.White;
            this.LBLnum.Font = new System.Drawing.Font("Century Gothic", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLnum.ForeColor = System.Drawing.Color.Blue;
            this.LBLnum.Location = new System.Drawing.Point(47, 454);
            this.LBLnum.Name = "LBLnum";
            this.LBLnum.Size = new System.Drawing.Size(234, 17);
            this.LBLnum.TabIndex = 1;
            this.LBLnum.Text = "Digite os números que deseja apostar:";
            // 
            // TXTent
            // 
            this.TXTent.AutoCompleteCustomSource.AddRange(new string[] {
            "100"});
            this.TXTent.AutoCompleteSource = System.Windows.Forms.AutoCompleteSource.CustomSource;
            this.TXTent.Font = new System.Drawing.Font("Century Gothic", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTent.ForeColor = System.Drawing.Color.Red;
            this.TXTent.Location = new System.Drawing.Point(50, 474);
            this.TXTent.MaxLength = 59;
            this.TXTent.Name = "TXTent";
            this.TXTent.Size = new System.Drawing.Size(350, 22);
            this.TXTent.TabIndex = 7;
            this.TXTent.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.TXTent_KeyPress);
            // 
            // BUTvap
            // 
            this.BUTvap.AccessibleDescription = "V";
            this.BUTvap.Font = new System.Drawing.Font("Century Gothic", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BUTvap.ForeColor = System.Drawing.Color.Blue;
            this.BUTvap.Location = new System.Drawing.Point(50, 503);
            this.BUTvap.Name = "BUTvap";
            this.BUTvap.Size = new System.Drawing.Size(115, 24);
            this.BUTvap.TabIndex = 8;
            this.BUTvap.Tag = "";
            this.BUTvap.Text = "Validar aposta";
            this.BUTvap.UseVisualStyleBackColor = true;
            this.BUTvap.Click += new System.EventHandler(this.Processamento_Click);
            // 
            // BUTlimp
            // 
            this.BUTlimp.AccessibleDescription = "L";
            this.BUTlimp.Font = new System.Drawing.Font("Century Gothic", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BUTlimp.ForeColor = System.Drawing.Color.Blue;
            this.BUTlimp.Location = new System.Drawing.Point(171, 502);
            this.BUTlimp.Name = "BUTlimp";
            this.BUTlimp.Size = new System.Drawing.Size(73, 25);
            this.BUTlimp.TabIndex = 9;
            this.BUTlimp.Text = "Limpar";
            this.BUTlimp.UseVisualStyleBackColor = true;
            this.BUTlimp.Click += new System.EventHandler(this.Processamento_Click);
            // 
            // LBLconsulta
            // 
            this.LBLconsulta.AutoSize = true;
            this.LBLconsulta.BackColor = System.Drawing.Color.White;
            this.LBLconsulta.Font = new System.Drawing.Font("Century Gothic", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLconsulta.ForeColor = System.Drawing.Color.Blue;
            this.LBLconsulta.Location = new System.Drawing.Point(421, 454);
            this.LBLconsulta.Name = "LBLconsulta";
            this.LBLconsulta.Size = new System.Drawing.Size(228, 17);
            this.LBLconsulta.TabIndex = 12;
            this.LBLconsulta.Text = "Digite nº do Protocolo para Consulta:";
            // 
            // TXTconsult
            // 
            this.TXTconsult.Location = new System.Drawing.Point(424, 474);
            this.TXTconsult.Multiline = true;
            this.TXTconsult.Name = "TXTconsult";
            this.TXTconsult.Size = new System.Drawing.Size(225, 22);
            this.TXTconsult.TabIndex = 13;
            // 
            // BUTcons
            // 
            this.BUTcons.AccessibleDescription = "C";
            this.BUTcons.Font = new System.Drawing.Font("Century Gothic", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BUTcons.ForeColor = System.Drawing.Color.Blue;
            this.BUTcons.Location = new System.Drawing.Point(529, 503);
            this.BUTcons.Name = "BUTcons";
            this.BUTcons.Size = new System.Drawing.Size(120, 24);
            this.BUTcons.TabIndex = 14;
            this.BUTcons.Text = "Consultar aposta.";
            this.BUTcons.UseVisualStyleBackColor = true;
            this.BUTcons.Click += new System.EventHandler(this.Processamento_Click);
            // 
            // BUTregras
            // 
            this.BUTregras.AccessibleDescription = "R";
            this.BUTregras.BackColor = System.Drawing.SystemColors.Control;
            this.BUTregras.Font = new System.Drawing.Font("Century Gothic", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BUTregras.ForeColor = System.Drawing.Color.Blue;
            this.BUTregras.Location = new System.Drawing.Point(324, 503);
            this.BUTregras.Name = "BUTregras";
            this.BUTregras.Size = new System.Drawing.Size(76, 24);
            this.BUTregras.TabIndex = 15;
            this.BUTregras.Text = "Regras";
            this.BUTregras.UseVisualStyleBackColor = false;
            this.BUTregras.Click += new System.EventHandler(this.Processamento_Click);
            // 
            // button2
            // 
            this.button2.Font = new System.Drawing.Font("Century Gothic", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button2.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(192)))));
            this.button2.Location = new System.Drawing.Point(250, 503);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(68, 24);
            this.button2.TabIndex = 17;
            this.button2.Text = "Sortear";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // BUTlistaapst
            // 
            this.BUTlistaapst.AccessibleDescription = "C";
            this.BUTlistaapst.Font = new System.Drawing.Font("Century Gothic", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BUTlistaapst.ForeColor = System.Drawing.Color.Blue;
            this.BUTlistaapst.Location = new System.Drawing.Point(424, 503);
            this.BUTlistaapst.Name = "BUTlistaapst";
            this.BUTlistaapst.Size = new System.Drawing.Size(99, 24);
            this.BUTlistaapst.TabIndex = 18;
            this.BUTlistaapst.Text = "Ver Todas";
            this.BUTlistaapst.UseVisualStyleBackColor = true;
            this.BUTlistaapst.Click += new System.EventHandler(this.BUTlistaapst_Click);
            // 
            // Projeto_Integrado_A_v2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.ClientSize = new System.Drawing.Size(695, 537);
            this.Controls.Add(this.BUTlistaapst);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.BUTregras);
            this.Controls.Add(this.BUTcons);
            this.Controls.Add(this.TXTconsult);
            this.Controls.Add(this.LBLconsulta);
            this.Controls.Add(this.BUTlimp);
            this.Controls.Add(this.BUTvap);
            this.Controls.Add(this.TXTent);
            this.Controls.Add(this.LBLnum);
            this.Name = "Projeto_Integrado_A_v2";
            this.Text = "Mega Time";
            this.Load += new System.EventHandler(this.Projeto_Integrado_A_v2_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label LBLnum;
        private System.Windows.Forms.TextBox TXTent;
        private System.Windows.Forms.Button BUTvap;
        private System.Windows.Forms.Button BUTlimp;
        private System.Windows.Forms.Label LBLconsulta;
        private System.Windows.Forms.TextBox TXTconsult;
        private System.Windows.Forms.Button BUTcons;
        private System.Windows.Forms.Button BUTregras;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button BUTlistaapst;
    }
}

