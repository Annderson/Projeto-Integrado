namespace Projeto_Integrado_A_
{
    partial class ListaApostas
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
            this.LSTapostas = new System.Windows.Forms.ListBox();
            this.BUTcons = new System.Windows.Forms.Button();
            this.BUTsair = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // LSTapostas
            // 
            this.LSTapostas.FormattingEnabled = true;
            this.LSTapostas.Location = new System.Drawing.Point(12, 38);
            this.LSTapostas.Name = "LSTapostas";
            this.LSTapostas.Size = new System.Drawing.Size(187, 251);
            this.LSTapostas.TabIndex = 0;
            // 
            // BUTcons
            // 
            this.BUTcons.Location = new System.Drawing.Point(12, 300);
            this.BUTcons.Name = "BUTcons";
            this.BUTcons.Size = new System.Drawing.Size(97, 23);
            this.BUTcons.TabIndex = 1;
            this.BUTcons.Text = "Consultar";
            this.BUTcons.UseVisualStyleBackColor = true;
            this.BUTcons.Click += new System.EventHandler(this.BUTcons_Click);
            // 
            // BUTsair
            // 
            this.BUTsair.Location = new System.Drawing.Point(115, 300);
            this.BUTsair.Name = "BUTsair";
            this.BUTsair.Size = new System.Drawing.Size(84, 23);
            this.BUTsair.TabIndex = 2;
            this.BUTsair.Text = "Sair";
            this.BUTsair.UseVisualStyleBackColor = true;
            this.BUTsair.Click += new System.EventHandler(this.BUTsair_Click);
            // 
            // ListaApostas
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(211, 335);
            this.Controls.Add(this.BUTsair);
            this.Controls.Add(this.BUTcons);
            this.Controls.Add(this.LSTapostas);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "ListaApostas";
            this.SizeGripStyle = System.Windows.Forms.SizeGripStyle.Hide;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "Apostas já Realizadas";
            this.Load += new System.EventHandler(this.ListaApostas_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.ListBox LSTapostas;
        private System.Windows.Forms.Button BUTcons;
        private System.Windows.Forms.Button BUTsair;

    }
}